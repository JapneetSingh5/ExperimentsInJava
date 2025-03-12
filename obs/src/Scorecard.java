class Scorecard implements Observer {
    private final Class<?> team1;
    private final Class<?> team2;
    int score1, score2;

    public Scorecard(Subject team1, Subject team2){
        this.team1 = team1.getClass();
        this.team2 = team2.getClass();
        this.score1 = 0;
        this.score2 = 0;
    }

    @Override
    public void update(Subject subject) {
        if (team1.isInstance(subject)){
            this.score1+=1;
        }else if(team2.isInstance(subject)){
            this.score2+=1;
        }
        System.out.println("TEAM1 "+score1+" : "+score2+" TEAM2");
    }
}
