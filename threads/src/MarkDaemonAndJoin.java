public class MarkDaemonAndJoin {
    public static void main(String[] args) throws InterruptedException {
        VanillaThread vt1 = new VanillaThread(1, 10);
        VanillaThread vt2 = new VanillaThread(2, 5);
        vt1.setDaemon(true);
        // will exit when vt2 exits and vt1 finishes since we are joining vt1
        vt1.start();
        vt2.start();
        vt1.join();
    }
}
