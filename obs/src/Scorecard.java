class Scorecard implements Observer {
    private final Class<?> team1;
    private final Class<?> team2;
    private final Team team1obj,team2obj;
    int score1, score2;

    public Scorecard(Team team1, Team team2){
        this.team1 = team1.getClass();
        this.team2 = team2.getClass();
        this.team1obj = team1;
        this.team2obj = team2;
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
        System.out.println(team1obj.getName()+" "+score1+" : "+score2+" "+team2obj.getName());
    }
}
