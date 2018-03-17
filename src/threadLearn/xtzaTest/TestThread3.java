package threadLearn.xtzaTest;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 13:18
 */
public class TestThread3 implements Runnable {
    private int sleepTime;
    public TestThread3(){
        sleepTime = (int)(Math.random()*6000);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+
                " going to sleep for "+sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName()+" finished");
    }
}
