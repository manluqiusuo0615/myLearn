package threadLearn.xtzaTest.sp2;

import threadLearn.xtzaTest.sp1.Tickets;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 15:02
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
            synchronized(tickets){
                if(tickets.available==true&&i< tickets.number){
                    System.out.println("卖的票的票号:"+(++i));
                }
                if(i== tickets.number){
                    System.out.println("卖的第几张票："+i+"===="+tickets.number);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) { }
                    tickets.available=false;
                }
            }
        }
        System.out.println("卖票操作完成!");
    }
}
