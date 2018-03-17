package threadLearn.xtzaTest;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 11:59
 */
public class FactorialThreadTester {
    public static void main(String[] args) {
        System.out.println("main thread starts");
        //FactorialThread thread = new FactorialThread(5);
        Thread thread = new Thread(new FactorialThread2(5));
        thread.start();
        try {
            System.out.println("主线程休眠时间开始......");
            Thread.sleep(3000);
            System.out.println("主线程休眠时间结束......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread end");
    }
}
