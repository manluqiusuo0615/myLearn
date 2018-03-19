package threadLearn.xtzaTest.sp1;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 14:08
 */
public class Consumer extends Thread {
    private Tickets tickets;
    private int i = 0 ;
    public Consumer(Tickets tickets){
        this.tickets = tickets;
    }
    @Override
    public void run() {
        while(i<tickets.size){
            if(tickets.available==true&&i< tickets.number){
                System.out.println("卖的票的票号:"+(++i));
            }
            //现有的票号卖完了
            if(i== tickets.number){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets.available=false;
            }
        }
    }
}
