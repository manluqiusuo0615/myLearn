package threadLearn.xtzaTest.sp3;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 15:55
 */
public class Producer implements Runnable{
    private Tickets tickets;
    public Producer(Tickets tickets){this.tickets=tickets;}
    @Override
    public void run() {
        while (tickets.number<tickets.size){
            tickets.put();
        }
    }
}
