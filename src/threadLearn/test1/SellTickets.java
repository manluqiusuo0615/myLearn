package threadLearn.test1;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 13:39
 */
public class SellTickets extends Thread {
    private int tickets = 200;
    @Override
    public void run() {
        while(tickets>0){
            System.out.println(Thread.currentThread().getName()+
                    "售卖："+tickets--);
        }
    }
}
