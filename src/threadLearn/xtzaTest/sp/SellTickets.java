package threadLearn.xtzaTest.sp;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 13:31
 */
public class SellTickets implements Runnable{
    private int tickets = 200;
    @Override
    public void run() {
        while(tickets>0){
            System.out.println(Thread.currentThread().getName()+
                    " is selling ticket "+tickets--);
        }
    }
}
