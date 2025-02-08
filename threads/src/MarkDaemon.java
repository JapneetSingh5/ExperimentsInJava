public class MarkDaemon {
    public static void main(String[] args) throws InterruptedException {
        VanillaThread vt1 = new VanillaThread(1, 10);
        VanillaThread vt2 = new VanillaThread(2, 5);
        vt1.setDaemon(true);
        // will exit when vt2 exits
        vt1.start();
        vt2.start();
    }
}
