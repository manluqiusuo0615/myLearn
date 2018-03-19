package threadLearn.xtzaTest.sp1;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 14:05
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        //建立票对象，票总数10
        Tickets t=new Tickets(10);
        //开始卖票线程
        new Consumer(t).start();
        //开始存票线程
        new Producer(t).start();
    }
}
