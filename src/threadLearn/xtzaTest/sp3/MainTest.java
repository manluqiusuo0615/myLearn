package threadLearn.xtzaTest.sp3;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 16:00
 */
public class MainTest {
    public static void main(String[] args) {
        Tickets tickets = new Tickets(10);
        new Thread(new Producer(tickets)).start();
        new Consumer(tickets).start();
    }
}
