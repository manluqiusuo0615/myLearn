package learn.Thread.producer_consumer.consumer;

import learn.Thread.producer_consumer.pojos.BaoZi;
import learn.Thread.producer_consumer.pojos.Basket;

/**
 * @author 肖长路
 * @Description 消费者
 * @create 2017-10-10 14:43
 */
public class Consumer extends Thread{
    private String consumer_name;
    private Basket basket;

    public String getConsumer_name() {
        return consumer_name;
    }

    public void setConsumer_name(String consumer_name) {
        this.consumer_name = consumer_name;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public BaoZi getOne(){
        return this.basket.getOne();
    }

    public Consumer(String consumer_name,Basket basket){
        this.consumer_name = consumer_name;
        this.basket = basket;
    }

    @Override
    public void run() {
        while(true){
            BaoZi baoZi = this.getOne();
            System.out.println(this.consumer_name+",吃掉了一个包子,编号为:"+baoZi.getIndex());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
