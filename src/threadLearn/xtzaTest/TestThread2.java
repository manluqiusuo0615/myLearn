package threadLearn.xtzaTest;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 13:01
 */
public class TestThread2 implements Runnable {
    private int sleepTime;
    public TestThread2(){
        sleepTime = (int)(Math.random()*6000);
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" going to sleep for "+sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" finished");
    }
}
