package learn.Thread.producer_consumer.producer;

import learn.Thread.producer_consumer.pojos.BaoZi;
import learn.Thread.producer_consumer.pojos.Basket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-10 14:31
 */
public class Producer extends Thread{
    //生产者名称
    private String product_name;
    //生产者的包子的序号
    private int product_seq = 1;
    //生产一个包子就要向篮子里面放
    //所以要有一个篮子的对象的引用
    private Basket basket;

    public int getProduct_seq() {
        return product_seq;
    }

    public void setProduct_seq(int product_seq) {
        this.product_seq = product_seq;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Producer(String product_name,Basket basket){
        this.product_name = product_name;
        this.basket = basket;
    }

    private BaoZi produce(){
        BaoZi baoZi = new BaoZi(this.product_name+"_"+this.product_seq);
        //每生产一个包子数量就加1
        this.product_seq++;
        return baoZi;
    }

    @Override
    public void run() {
        while (true){
            BaoZi baoZi = this.produce();
            this.basket.addOne(baoZi);
            System.out.println(this.getProduct_name()+",生产了的包子名称:"+baoZi.getIndex());

            try {
                //生产一个休息3秒
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
