package threadLearn.xtzaTest;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 12:25
 */
public class ThreadSleepTester {
    public static void main(String[] args) {
        //创建并命名每个线程
        //TestThread thread1 = new TestThread("thread1");
        //TestThread thread2 = new TestThread("thread2");
        //TestThread thread3 = new TestThread("thread3");
        Thread thread1 = new Thread(new TestThread2(),"thread1");
        Thread thread2 = new Thread(new TestThread2(),"thread2");
        Thread thread3 = new Thread(new TestThread2(),"thread3");
        System.out.println("Starting threads");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Theads started main ends\n");
    }
}
