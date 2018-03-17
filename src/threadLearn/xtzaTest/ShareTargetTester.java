package threadLearn.xtzaTest;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 13:17
 */
public class ShareTargetTester {
    public static void main(String[] args) {
        TestThread3 threadobj = new TestThread3();
        System.out.println("Starting threads");

        new Thread(threadobj,"Thread1").start();
        new Thread(threadobj,"Thread2").start();
        new Thread(threadobj,"Thread3").start();

        System.out.println("Threads started,main ends\n");
    }
}
