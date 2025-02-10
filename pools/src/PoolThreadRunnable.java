import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable{
    private Thread thread = null;
    private BlockingQueue queue = null;
    private boolean isStopped = false;

    public PoolThreadRunnable(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        // the thread this run() will execute on
        this.thread = Thread.currentThread();
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) queue.take();
                runnable.run();
            } catch (InterruptedException e) {
                System.out.println("Interrupt encountered on thread "+this.thread.getName());
                System.out.println("Was stopped "+isStopped);
//                throw new RuntimeException(e);
            }
        }
    }

    public void doStop(){
        isStopped = true;
        // break thread
        this.thread.interrupt();
    }

    private boolean isStopped(){
        return isStopped;
    }

}
