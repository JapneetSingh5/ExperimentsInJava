import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
A thread pool is a pool of threads that can be "reused" to execute tasks

Creating a new thread has a performance overhead v/s reusing an already created thread
Reusing a thread can thus result in a higher net throughput

Too many threads also means more RAM utilisation, OS may start swapping RAM to disk

Java has a built-in thread pool called ExecutorService, but let's try build one ourselves

As soon as a thread is idle, the next task is assigned to it (if any, queue of tasks is maintained)
 */
public class ThreadPool {
    // bLocking queues aree interesting,
    // Producer Consumer pattern see https://jenkov.com/tutorials/java-concurrency/producer-consumer.html
    private BlockingQueue taskQ = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int threadCount, int maxTasks){
        taskQ = new ArrayBlockingQueue(maxTasks);
        for(int i=0; i<threadCount; i++){
            PoolThreadRunnable runnable = new PoolThreadRunnable(taskQ);
            runnables.add(runnable);
        }
        for(PoolThreadRunnable runnable: runnables) {
            new Thread(runnable).start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception{
        if(isStopped){
            throw new IllegalStateException("ThreadPool is stopped");
        }
        this.taskQ.offer(task);
    }

    public void stop(){
        this.isStopped = true;
        for(PoolThreadRunnable runnable: runnables){
            runnable.doStop();
        }
    }

    public void waitUntilAllTasksFinished() throws InterruptedException {
        while(!this.taskQ.isEmpty()) {
            Thread.sleep(1);
        }
    }

    public static void main(String[] args) throws Exception {

        ThreadPool threadPool = new ThreadPool(3, 10);

        for(int i=0; i<10; i++) {

            int taskNo = i;
            threadPool.execute( () -> {
                String message =
                        Thread.currentThread().getName()
                                + ": Task " + taskNo ;
                System.out.println(message);
            });
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}