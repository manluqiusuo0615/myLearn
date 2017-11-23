package learn.Thread.producer_consumer.pojos;

/**
 * @author 肖长路
 * @Description 包子的封装类
 * @create 2017-10-10 14:30
 */
public class BaoZi {
    //包子的编号,唯一标识
    private String index;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public BaoZi(String index){
        this.index = index;
    }
}
