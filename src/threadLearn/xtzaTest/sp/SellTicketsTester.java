package threadLearn.xtzaTest.sp;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 13:30
 */
public class SellTicketsTester {
    public static void main(String[] args) {
        SellTickets t = new SellTickets();

        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
