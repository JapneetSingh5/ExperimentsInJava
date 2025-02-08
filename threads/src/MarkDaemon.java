public class MarkDaemon {
    public static void main(String[] args) throws InterruptedException {
        VanillaThread vt1 = new VanillaThread(1, 10);
        VanillaThread vt2 = new VanillaThread(2, 5);
        vt1.setDaemon(true);
        // will exit when vt2 exits
        // A daemon thread in Java is a thread that does not keep the Java Virtual Machine (JVM) running if the main thread
        // exits the application. A non-daemon thread will keep the JVM running even if the main thread exits the application.
        // https://en.wikipedia.org/wiki/Daemon_(computing)
        vt1.start();
        vt2.start();
    }
}
