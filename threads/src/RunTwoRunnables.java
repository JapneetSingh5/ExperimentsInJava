public class RunTwoRunnables {
    public static void main(String[] args) throws InterruptedException {
        // anonymous class
        Runnable r1 = new Runnable() {
            final int threadNumber=1;
            final int countTill=10;
            @Override
            public void run() {
                System.out.println("Running Thread "+this.threadNumber);
                for(int i=1; i<=countTill; i++){
                    System.out.println("Tick Thread "+this.threadNumber+" -> "+i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        // lambda runnable
        Runnable r2 = () -> {
            System.out.println("Running Thread 2");
            for(int i=1; i<=10; i++){
                System.out.println("Tick Thread 2 -> "+i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
