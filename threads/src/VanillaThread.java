public class VanillaThread extends Thread{
    int threadNumber;
    int countTill;
    public VanillaThread(int threadNumber, int countTill){
        this.threadNumber = threadNumber;
        this.countTill = countTill;
    }

    @Override
    public void run(){
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
}