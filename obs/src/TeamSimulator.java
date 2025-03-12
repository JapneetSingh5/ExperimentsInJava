import static java.lang.Thread.sleep;

public class TeamSimulator implements Runnable{
    private final Team team;
    private int maxScore;
    private int sleepInterval;

    public TeamSimulator(Team team, int maxScore, int sleepInterval) {
        this.team = team;
        this.maxScore = maxScore;
        this.sleepInterval = sleepInterval;
    }

    @Override
    public void run() {
        while(team.getScore()<maxScore){
            team.goal();
            try {
                sleep(sleepInterval);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        }

    }
}
