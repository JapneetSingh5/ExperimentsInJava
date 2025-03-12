//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Team home = new Home();
        Team away = new Away();
        Scorecard sc = new Scorecard(home, away);
        home.registerObserver(sc);
        away.registerObserver(sc);
        TeamSimulator hs = new TeamSimulator(home, 6, 500);
        TeamSimulator as = new TeamSimulator(away, 8, 400);
        Thread homeThread = new Thread(hs);
        Thread awayThread = new Thread(as);
        homeThread.start();
        awayThread.start();
        homeThread.join();
        awayThread.join();
    }
}