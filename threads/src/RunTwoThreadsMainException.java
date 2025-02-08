public class RunTwoThreadsMainException {
    public static void main(String[] args) throws InterruptedException {
        VanillaThread vt1 = new VanillaThread(1, 3);
        VanillaThread vt2 = new VanillaThread(2, 3);
        vt1.start();
        vt2.start();
        throw new RuntimeException();
    }
}
