package threadLearn.test1;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 11:43
 */
public class MainTest {
    public static void main(String[] args) {
        //Thread test1 = new Test1();
        //Thread thread = new Thread(new Test2());
        //
        //test1.start();
        //thread.start();
        Thread thread1 = new SellTickets();
        Thread thread2 = new SellTickets();
        Thread thread3 = new SellTickets();
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
