package com.code;

public class Match {
    private int id;
    private int season;
    private String city;
    private  String date;
    private String team1;
    private  String team2;
    private String toss_winner;
    private String toss_decision;
    private String result;
    private int dl_applied;
    private String winner;
    private int win_by_runs;
    private int win_by_wickets;
    private String player_of_match;
    private String venue;
    private String umpire1;
    private String umpire2;
    private String umpire3;

    public void setId(int x){this.id=x;}

    public void setSeason(int x){
        this.season=x;
    }
    public void setCity(String s){
        this.city=s;
    }
    public void setDate(String s){
        this.date=s;
    }

    public void setTeam1(String s){
        this.team1=s;
    }

    public void setTeam2(String s){
        this.team2=s;
    }

    public void setTossWinner(String s){
        this.toss_winner=s;
    }

    public void setTossDecision(String s){
        this.toss_decision=s;
    }

    public void setResult(String s){
        this.result=s;
    }

    public void setDlApplied(int x){
        this.dl_applied=x;
    }

    public void setWinner(String s){
        this.winner=s;
    }
    public void setWinByRuns(int x){
        this.win_by_runs=x;
    }

    public void setWinByWickets(int x){
        this.win_by_wickets=x;
    }

    public void setPlayerOfMatch(String s){
        this.player_of_match=s;
    }

    public void setVenue(String s){
        this.venue=s;
    }

    public void setUmpire1(String s){
        this.umpire1=s;
    }
    public void setUmpire2(String s){
        this.umpire2=s;
    }
    public void setUmpire3(String s){
        this.umpire3=s;
    }

    public int getId(){
        return this.id;
    }

    public int getSeason(){
        return this.season;
    }
    public String getCity(){
        return this.city;
    }
    public String getDate(){
        return this.date;
    }

    public String getTeam1(){
        return this.team1;
    }

    public String getTeam2(){
        return this.team2;
    }

    public String getTossWinner(){
        return this.toss_winner;
    }

    public String getTossDecision(){
        return this.toss_decision;
    }

    public String getResult(){
        return this.result;
    }

    public int getDlApplied(){
        return this.dl_applied;
    }

    public String getWinner(){
        return this.winner;
    }
    public int getWinByRuns(){
        return this.win_by_runs;
    }

    public int getWinByWickets(){
        return this.win_by_wickets;
    }

    public String getPlayerOfMatch(){
        return this.player_of_match;
    }
    public String getVenue(){
        return this.venue;
    }
    public String getUmpire1(){
        return this.umpire1;
    }
    public String getUmpire2(){
        return this.umpire2;
    }
    public String getUmpire3(){
        return this.umpire3;
    }
}
