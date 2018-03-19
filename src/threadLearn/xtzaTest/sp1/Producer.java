package threadLearn.xtzaTest.sp1;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 14:07
 */
public class Producer extends Thread {
    private Tickets tickets;
    public Producer(Tickets tickets){
        this.tickets = tickets;
    }
    @Override
    public void run() {
        while (tickets.number<tickets.size){
            System.out.println("存的票的票号:"+(++tickets.number));
            tickets.available=true;
        }
    }
}
