package threadLearn.xtzaTest;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 12:26
 */
public class TestThread extends Thread {
    private int sleepTime;
    public TestThread(String str){
        super(str);
        sleepTime = (int)(Math.random()*6000);
    }
    @Override
    public void run() {

        try {
            System.out.println(getName()+" going to sleep for "+sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+" finished");
    }
}
