package threadLearn.xtzaTest.sp3;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 15:54
 */
public class Consumer extends Thread {
    private Tickets tickets;
    public Consumer(Tickets tickets){this.tickets=tickets;}
    @Override
    public void run() {
        while(tickets.i<tickets.size){
            tickets.sell();
        }
    }
}
