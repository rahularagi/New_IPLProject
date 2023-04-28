package com.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Match> matches=matchReader();
        List<Deliveries> deliveries=deliveriesReader();

        findNumberOfMatchesPlayedPerYear(matches);
        findNumberOfMatchesWinByEachTeam(matches);
        findExtraRunsConcededPerTeamIn2016(matches,deliveries);
        findTopEconomicalBowlerForTheYear2015(matches,deliveries);
        findtotalRunsOfEachPlayerInIPL(deliveries);

    }

    private static List<Match> matchReader(){
        List<Match> matches= new ArrayList<>();
        String file ="src//matches.csv";
        BufferedReader reader=null;
        String line="";

        try{
            reader=new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line=reader.readLine()) != null){
                String [] data=line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Match m=new Match();

                m.setid(Integer.parseInt(data[0]));

                m.setseason(Integer.parseInt(data[1]));

                m.setcity(data[2]);

                m.setdate(data[3]);

                m.setteam1(data[4]);
                m.setteam2(data[5]);

                m.settoss_winner(data[6]);
                m.settoss_decision(data[7]);
                m.setresult(data[8]);
                m.setdl_applied(Integer.parseInt(data[9]));
                m.setwinnwr(data[10]);

                m.setwin_by_runs(Integer.parseInt(data[11]));
                m.setwin_by_wickets(Integer.parseInt(data[12]));
                m.setplayer_of_match(data[13]);
                m.setvenue(data[14]);
                m.setumpire1(data[15]);
                m.setumpire2(data[16]);
                m.setumpire3(data[17]);

                matches.add(m);

            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                reader.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        return matches;
    }

    private static List<Deliveries> deliveriesReader(){
        List<Deliveries> deliveries=new ArrayList ();
        String file="src//deliveries.csv";
        BufferedReader reader=null;
        String line="";

        try{
            reader=new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line= reader.readLine()) !=null){
                String [] data=line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);


                Deliveries d=new Deliveries();

                d.setmatch_id(Integer.parseInt(data[0]));

                d.setinning(Integer.parseInt(data[1]));

                d.setbatting_team(data[2]);

                d.setbowling_team(data[3]);

                d.setover(Integer.parseInt(data[4]));

                d.setball(Integer.parseInt(data[5]));

                d.setbatsman(data[6]);

                d.setnon_striker(data[7]);

                d.setbowler(data[8]);

                d.setis_super_over(Integer.parseInt(data[9]));

                d.setwide_runs(Integer.parseInt(data[10]));

                d.setbye_runs(Integer.parseInt(data[11]));

                d.setlegbye_runs(Integer.parseInt(data[12]));
                d.setnoball_runs(Integer.parseInt(data[13]));

                d.setpenalty_runs(Integer.parseInt(data[14]));

                d.setbatsman_runs(Integer.parseInt(data[15]));

                d.setextra_runs(Integer.parseInt(data[16]));

                d.settotal_runs(Integer.parseInt(data[17]));

                d.setplayer_dismissed(data[18]);

                d.setdismissal_kind(data[19]);

                d.setfielder(data[20]);

                deliveries.add(d);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                reader.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        return deliveries;
    }

    private static void findNumberOfMatchesPlayedPerYear(List<Match> matches){
        Map<Integer,Integer> yearAndTotalMatches=new HashMap<>();

        for(int i=0;i< matches.size();i++){
            if(!yearAndTotalMatches.containsKey(matches.get(i).getseason())){
                yearAndTotalMatches.put(matches.get(i).getseason(),1);
            }
            else{
                yearAndTotalMatches.put(matches.get(i).getseason(),(yearAndTotalMatches.get(matches.get(i).getseason())+1));
            }
        }
        System.out.println("total number of years: " +yearAndTotalMatches.size());
        for(Map.Entry m : yearAndTotalMatches.entrySet()){
            System.out.println("Year: "+m.getKey()+"  number of matches played: "+m.getValue());
        }
        System.out.println();

    }

    private static void findNumberOfMatchesWinByEachTeam(List<Match> matches){
        System.out.println("Number of matches win by team");
        Map<String,Integer> teamWinCount=new HashMap();

        for(int i=0;i<matches.size();i++){
            if(matches.get(i).getwinnwr()!="") {
                if (!teamWinCount.containsKey(matches.get(i).getwinnwr())) {
                    teamWinCount.put(matches.get(i).getwinnwr(), 1);
                } else {
                    teamWinCount.put(matches.get(i).getwinnwr(), (teamWinCount.get(matches.get(i).getwinnwr()) + 1));
                }
            }
        }

        System.out.println("total number of teams: " +teamWinCount.size());
        for(Map.Entry m : teamWinCount.entrySet()){
            System.out.println("Team name: "+m.getKey()+" Number of times win: "+m.getValue());
        }
        System.out.println();
    }

    private static void findExtraRunsConcededPerTeamIn2016(List<Match> matches,List<Deliveries> deliveries){
        System.out.println("Extra runs conceded per team in the year 2016 get ");
        Map<String,Integer> extraRunsPerTeam=new HashMap<>();

        for(int i=0;i< matches.size();i++){
            if(matches.get(i).getseason()==2016){
                for(int j=0;j<deliveries.size();j++){
                    if(matches.get(i).getid()==deliveries.get(j).getmatch_id()&&deliveries.get(j).getextra_runs()!=0){
                        if(!extraRunsPerTeam.containsKey(deliveries.get(j).getbatting_team())){
                            extraRunsPerTeam.put(deliveries.get(j).getbatting_team(),deliveries.get(j).getextra_runs());
                        }
                        else{
                            extraRunsPerTeam.put(deliveries.get(j).getbatting_team(),(extraRunsPerTeam.get(deliveries.get(j).getbatting_team())+deliveries.get(j).getextra_runs()));
                        }
                    }
                }
            }
        }

        System.out.println("total number of teams: " +extraRunsPerTeam.size());
        for(Map.Entry m : extraRunsPerTeam.entrySet()){
            System.out.println("team name: "+m.getKey()+" Extra runs : "+m.getValue());
        }
        System.out.println();
    }

    private static void findTopEconomicalBowlerForTheYear2015(List<Match> matches,List<Deliveries> deliveries){
        System.out.println("For the year of 2015 top economical bowler");
        Map<String,Integer> totalBallsThrownByBowler=new TreeMap<>();
        Map<String,Integer> totalRunsGivenByBowler=new TreeMap<>();
        TreeMap<Float,String> ec=new TreeMap<>();


        for(int j=0;j<matches.size();j++) {
            if(matches.get(j).getseason()==2015) {

                for (int i = 0; i < deliveries.size(); i++) {
                    if(matches.get(j).getid()==deliveries.get(i).getmatch_id()) {
                        if (!totalBallsThrownByBowler.containsKey(deliveries.get(i).getbowler())) {
                            totalBallsThrownByBowler.put(deliveries.get(i).getbowler(), 1);
                            totalRunsGivenByBowler.put(deliveries.get(i).getbowler(), deliveries.get(i).gettotal_runs());
                        } else {
                            totalBallsThrownByBowler.put(deliveries.get(i).getbowler(), (totalBallsThrownByBowler.get(deliveries.get(i).getbowler()) + 1));
                            totalRunsGivenByBowler.put(deliveries.get(i).getbowler(), (totalBallsThrownByBowler.get(deliveries.get(i).getbowler()) + deliveries.get(i).gettotal_runs()));
                        }
                        float over = totalBallsThrownByBowler.get(deliveries.get(i).getbowler()) / 6f;
                        float runs = totalRunsGivenByBowler.get(deliveries.get(i).getbowler());
                        float ecnomic = runs / over;
                        if(ecnomic!=0) {
                            ec.put(ecnomic, deliveries.get(i).getbowler());
                        }
                    }
                }
            }
        }

        System.out.println("Top economical bowler for the year 2015: "+ec.firstEntry());
        System.out.println();
    }

    private static void findtotalRunsOfEachPlayerInIPL(List<Deliveries> deliveries) {
        System.out.println("Total runs of each player in ipl");
        Map<String,Integer> playerNameAndRuns=new HashMap<>();

        for(int i=0;i<deliveries.size();i++){
            if(!playerNameAndRuns.containsKey(deliveries.get(i).getbatsman())){
                playerNameAndRuns.put(deliveries.get(i).getbatsman(),deliveries.get(i).getbatsman_runs());
            }
            else{
                playerNameAndRuns.put(deliveries.get(i).getbatsman(),( playerNameAndRuns.get(deliveries.get(i).getbatsman())+deliveries.get(i).getbatsman_runs()));
            }
        }

        System.out.println("total number of players: " +playerNameAndRuns.size());
        for(Map.Entry m : playerNameAndRuns.entrySet()){
            System.out.println("Player_name: "+m.getKey()+",Total runs: "+m.getValue());
        }
    }

}