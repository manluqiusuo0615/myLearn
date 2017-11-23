package learn.Thread.producer_consumer.pojos;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 肖长路
 * @Description 包子的容器对象, 负责包子放入和拿出
 * @create 2017-10-10 14:37
 */
public class Basket {
    private int index;
    private LinkedList<BaoZi> baoZiList;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public LinkedList<BaoZi> getBaoZiList() {
        return baoZiList;
    }

    public void setBaoZiList(LinkedList<BaoZi> baoZiList) {
        this.baoZiList = baoZiList;
    }

    public Basket(int index) {
        this.index = index;
        this.baoZiList = new LinkedList<BaoZi>();
    }

    public void addOne(BaoZi baoZi) {
        synchronized (this) {
            this.baoZiList.add(baoZi);
            this.notifyAll();
        }
    }

    public BaoZi getOne() {
        synchronized (this) {
            BaoZi one = this.baoZiList.pollFirst();
            while (one == null) {
                try {
                    System.out.println("消费者在等待！！！");
                    this.wait();
                    one = this.baoZiList.pollFirst();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return one;
        }
    }
}
