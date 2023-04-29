package com.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Match> matches=matchReader();
        List<Deliveries> deliveries=deliveriesReader();

        findNumberOfMatchesPlayedPerYear(matches);
        findNumberOfMatchesWinByEachTeam(matches);
        findExtraRunsConcededPerTeamIn2016(matches,deliveries);
        findTopEconomicalBowlerForTheYear2015(matches,deliveries);
       findTotalRunsOfEachPlayerInIPL(deliveries);
       findStrikeRateBatsmanIn2016(matches,deliveries);

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

                m.setId(Integer.parseInt(data[0]));

                m.setSeason(Integer.parseInt(data[1]));

                m.setCity(data[2]);

                m.setDate(data[3]);

                m.setTeam1(data[4]);
                m.setTeam2(data[5]);

                m.setTossWinner(data[6]);
                m.setTossDecision(data[7]);
                m.setResult(data[8]);
                m.setDlApplied(Integer.parseInt(data[9]));
                m.setWinner(data[10]);

                m.setWinByRuns(Integer.parseInt(data[11]));
                m.setWinByWickets(Integer.parseInt(data[12]));
                m.setPlayerOfMatch(data[13]);
                m.setVenue(data[14]);
                m.setUmpire1(data[15]);
                m.setUmpire2(data[16]);
                m.setUmpire3(data[17]);

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

                d.setMatchId(Integer.parseInt(data[0]));

                d.setInning(Integer.parseInt(data[1]));

                d.setBattingTeam(data[2]);

                d.setBowlingTeam(data[3]);

                d.setOver(Integer.parseInt(data[4]));

                d.setBall(Integer.parseInt(data[5]));

                d.setBatsMan(data[6]);

                d.setNonStriker(data[7]);

                d.setBowler(data[8]);

                d.setIsSuperOver(Integer.parseInt(data[9]));

                d.setWideRuns(Integer.parseInt(data[10]));

                d.setByeRuns(Integer.parseInt(data[11]));

                d.setLegByeRuns(Integer.parseInt(data[12]));
                d.setNoBallRuns(Integer.parseInt(data[13]));

                d.setPenaltyRuns(Integer.parseInt(data[14]));

                d.setBatsmanRuns(Integer.parseInt(data[15]));

                d.setExtraRuns(Integer.parseInt(data[16]));

                d.setTotalRuns(Integer.parseInt(data[17]));

                d.setPlayerDismissed(data[18]);

                d.setDisMissalKind(data[19]);

                d.setFielder(data[20]);

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
            if(!yearAndTotalMatches.containsKey(matches.get(i).getSeason())){
                yearAndTotalMatches.put(matches.get(i).getSeason(),1);
            }
            else{
                yearAndTotalMatches.put(matches.get(i).getSeason(),(yearAndTotalMatches.get(matches.get(i).getSeason())+1));
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
            if(matches.get(i).getWinner()!="") {
                if (!teamWinCount.containsKey(matches.get(i).getWinner())) {
                    teamWinCount.put(matches.get(i).getWinner(), 1);
                } else {
                    teamWinCount.put(matches.get(i).getWinner(), (teamWinCount.get(matches.get(i).getWinner()) + 1));
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
            if(matches.get(i).getSeason()==2016){
                for(int j=0;j<deliveries.size();j++){
                    if(matches.get(i).getId()==deliveries.get(j).getMatchId()&&deliveries.get(j).getExtraRuns()!=0){
                        if(!extraRunsPerTeam.containsKey(deliveries.get(j).getBattingTeam())){
                            extraRunsPerTeam.put(deliveries.get(j).getBattingTeam(),deliveries.get(j).getExtraRuns());
                        }
                        else{
                            extraRunsPerTeam.put(deliveries.get(j).getBattingTeam(),(extraRunsPerTeam.get(deliveries.get(j).getBattingTeam())+deliveries.get(j).getExtraRuns()));
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
        Map<String,Float> bowlersEconomy=new HashMap<>();


        for(int j=0;j<matches.size();j++) {
            if(matches.get(j).getSeason()==2015) {

                for (int i = 0; i < deliveries.size(); i++) {
                    if(matches.get(j).getId()==deliveries.get(i).getMatchId()) {
                        if (!totalBallsThrownByBowler.containsKey(deliveries.get(i).getBowler())) {
                            totalBallsThrownByBowler.put(deliveries.get(i).getBowler(), 1);
                            totalRunsGivenByBowler.put(deliveries.get(i).getBowler(), deliveries.get(i).getTotalRuns());
                        } else {
                            totalBallsThrownByBowler.put(deliveries.get(i).getBowler(), (totalBallsThrownByBowler.get(deliveries.get(i).getBowler()) + 1));
                            totalRunsGivenByBowler.put(deliveries.get(i).getBowler(), (totalBallsThrownByBowler.get(deliveries.get(i).getBowler()) + deliveries.get(i).getTotalRuns()));
                        }
                        float over = totalBallsThrownByBowler.get(deliveries.get(i).getBowler()) / 6f;
                        float runs = totalRunsGivenByBowler.get(deliveries.get(i).getBowler());
                        float economy = runs / over;
                        if(economy!=0) {
                            bowlersEconomy.put(deliveries.get(i).getBowler(),economy);
                        }
                    }
                }
            }
        }

        TreeMap<Float,String> sortedBowlersEconomy=new TreeMap<>();
        for(Map.Entry m : bowlersEconomy.entrySet()){

            sortedBowlersEconomy.put((Float)m.getValue(),(String)m.getKey());
        }


        System.out.println("Top economical bowler for the year 2015: "+sortedBowlersEconomy.get(sortedBowlersEconomy.firstKey())+" = "+sortedBowlersEconomy.firstKey());
        System.out.println();
    }

    private static void findTotalRunsOfEachPlayerInIPL(List<Deliveries> deliveries) {
        System.out.println("Total runs of each player in ipl");
        Map<String,Integer> playerNameAndRuns=new HashMap<>();

        for(int i=0;i<deliveries.size();i++){
            if(!playerNameAndRuns.containsKey(deliveries.get(i).getBatsMan())){
                playerNameAndRuns.put(deliveries.get(i).getBatsMan(),deliveries.get(i).getBatsManRuns());
            }
            else{
                playerNameAndRuns.put(deliveries.get(i).getBatsMan(),( playerNameAndRuns.get(deliveries.get(i).getBatsMan())+deliveries.get(i).getBatsManRuns()));
            }
        }

        System.out.println("total number of players: " +playerNameAndRuns.size());
        for(Map.Entry m : playerNameAndRuns.entrySet()){
            System.out.println("Player_name: "+m.getKey()+",Total runs: "+m.getValue());
        }
    }



    private static void findStrikeRateBatsmanIn2016(List<Match> matches, List<Deliveries> deliveries) {
        System.out.println("Strike rate of each batsman");
        Map<String,Integer> totalBallsPlayedByBatsman=new TreeMap<>();
        Map<String,Integer> totalRunsOfBatsman=new TreeMap<>();
        Map<String,Float> stikeRates=new HashMap<>();


        for(int j=0;j<matches.size();j++) {
            if(matches.get(j).getSeason()==2016) {

                for (int i = 0; i < deliveries.size(); i++) {
                    if(matches.get(j).getId()==deliveries.get(i).getMatchId()) {
                        if (!totalBallsPlayedByBatsman.containsKey(deliveries.get(i).getBatsMan())) {
                            totalBallsPlayedByBatsman.put(deliveries.get(i).getBatsMan(), 1);
                            totalRunsOfBatsman.put(deliveries.get(i).getBatsMan(), deliveries.get(i).getBatsManRuns());
                        } else {
                            totalBallsPlayedByBatsman.put(deliveries.get(i).getBatsMan(), (totalBallsPlayedByBatsman.get(deliveries.get(i).getBatsMan()) + 1));
                            totalRunsOfBatsman.put(deliveries.get(i).getBatsMan(), (totalRunsOfBatsman.get(deliveries.get(i).getBatsMan()) + deliveries.get(i).getBatsManRuns()));
                        }
                        float balls = totalBallsPlayedByBatsman.get(deliveries.get(i).getBatsMan()) ;
                        float runs = totalRunsOfBatsman.get(deliveries.get(i).getBatsMan());
                        float strikeRate = (runs / balls)*100;
                        if(strikeRate!=0) {
                            stikeRates.put(deliveries.get(i).getBatsMan(),strikeRate);
                        }
                    }
                }
            }
        }

        TreeMap<Float,String> sortedStrikeRates=new TreeMap<>();

       for(Map.Entry m : stikeRates.entrySet()){
            System.out.println("Player name: "+m.getKey()+" Strike rate: "+m.getValue());
           sortedStrikeRates.put((Float)m.getValue(),(String)m.getKey());
        }
        System.out.println();
        System.out.println("Top 5 strike rates");
        int n=0;
        while(n<5){
            System.out.println("Player Name: "+sortedStrikeRates.get(sortedStrikeRates.lastKey())+" Strike rate: "+sortedStrikeRates.lastKey());
            sortedStrikeRates.remove(sortedStrikeRates.lastKey());
            n++;
        }
    }

}