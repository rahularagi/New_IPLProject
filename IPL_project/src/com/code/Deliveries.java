package com.code;

public class Deliveries {
    private int match_id;
    private int inning;
    private String  batting_team;
    private String bowling_team;
    private int over;
    private int ball;
    private String batsman;
    private String non_striker;
    private String bowler;
    private int is_super_over;
    private int wide_runs;
    private int bye_runs;
    private int legbye_runs;
    private int noball_runs;
    private int penalty_runs;
    private int batsman_runs;
    private int extra_runs;
    private int total_runs;
    private String player_dismissed;
    private String dismissal_kind;
    private String fielder;

    public void setMatchId(int x){
        this.match_id=x;
    }
    public void setInning(int x){
        this.inning=x;
    }

    public void setBattingTeam(String s){
        this.batting_team=s;
    }

    public void setBowlingTeam(String s){
        this.bowling_team=s;
    }
    public void setOver(int x){
        this.over=x;
    }

    public void setBall(int x){
        this.ball=x;
    }

    public void setBatsMan(String s){
        this.batsman=s;
    }

    public void setNonStriker(String s){
        this.non_striker=s;
    }

    public void setBowler(String s){
        this.bowler=s;
    }

    public void setIsSuperOver(int x){
        this.is_super_over=x;
    }

    public void setWideRuns(int x){
        this.wide_runs=x;
    }

    public void setByeRuns(int x){
        this.bye_runs=x;
    }

    public void setLegByeRuns(int x){
        this.legbye_runs=x;
    }
    public void setNoBallRuns(int x){
        this.noball_runs=x;
    }

    public void setPenaltyRuns(int x){
        this.penalty_runs=x;
    }

    public void setBatsmanRuns(int x){
        this.batsman_runs=x;
    }

    public void setExtraRuns(int x){
        this.extra_runs=x;
    }

    public void setTotalRuns(int x){
        this.total_runs=x;
    }

    public void setPlayerDismissed(String s){
        this.player_dismissed=s;
    }

    public void setDisMissalKind(String s){
        this.dismissal_kind=s;
    }

    public void setFielder(String s){
        this.fielder=s;
    }

    public int getMatchId(){
        return this.match_id;
    }
    public int getInning(){
        return this.inning;
    }

    public String getBattingTeam(){
        return this.batting_team;
    }

    public String getBowlingTeam(){
        return this.bowling_team;
    }
    public int getOver(){
        return this.over;
    }

    public int getBall(){
        return this.ball;
    }

    public String getBatsMan(){
        return this.batsman;
    }

    public String getNonStriker(){
        return this.non_striker;
    }

    public String getBowler(){
        return this.bowler;
    }

    public int getIsSuperOver(){
        return this.is_super_over;
    }

    public int getWideRuns(){
        return this.wide_runs;
    }

    public int getByeRuns(){
        return this.bye_runs;
    }

    public int getLegByeRuns(){
        return this.legbye_runs;
    }
    public int getNoballRuns(){
        return this.noball_runs;
    }

    public int getPenaltyRuns(){
        return this.penalty_runs;
    }

    public int getBatsManRuns(){
        return this.batsman_runs;
    }

    public int getExtraRuns(){
        return this.extra_runs;
    }

    public int getTotalRuns(){
        return this.total_runs;
    }

    public String getPlayerDismissed(){
        return this.player_dismissed;
    }

    public String getDisMissalKind(){
        return this.dismissal_kind;
    }

    public String getFielder(){
        return this.fielder;
    }


}
