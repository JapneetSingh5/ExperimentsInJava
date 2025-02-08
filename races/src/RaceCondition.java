import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {
    // 2 types of race conditions

    // Read-Modify-Write
    // - multiple threads read a value
    // - modify the value according to the logic, in their cpu register
    // - write it back

    // Check-then-Act
    // - multiple threads check a value, at the same time
    // - find condition satisfied, first one acts
    // - rest will have condition satisfied but will get a problematic/unexpected value instead
    public static class MyObject{
        int count = 0;
        void increment(){
//            synchronized (this) { // uncomment to fix
                count++;
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final MyObject counter = new MyObject();
        Runnable r1 = () -> {
            for(int i=0; i<10000; i++) {
                counter.increment();
            }
        };
        Runnable r2 = () -> {
            for(int i=0; i<10000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
//        t1.join(); // uncomment to get desired value
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.count);
    }

    // outputs
    // 13796
    // 14202
    // 14137
}