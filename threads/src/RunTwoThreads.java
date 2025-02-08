public class RunTwoThreads {
    public static void main(String[] args) throws InterruptedException {
        VanillaThread vt1 = new VanillaThread(1, 10);
        VanillaThread vt2 = new VanillaThread(2, 10);
        vt1.start();
        vt2.start();
    }
}
