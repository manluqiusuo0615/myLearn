package threadLearn.xtzaTest.sp2;

import threadLearn.xtzaTest.sp1.Tickets;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 15:02
 */
public class Producer extends Thread {
    private Tickets tickets;
    public Producer(Tickets tickets){
        this.tickets = tickets;
    }
    @Override
    public void  run() {
        while(tickets.number<tickets.size){
            synchronized(tickets){
                System.out.println("存的票的票号:"+(++tickets.number));
                tickets.available=true;
            }
        }
        System.out.println("存票完成!");
    }
}
