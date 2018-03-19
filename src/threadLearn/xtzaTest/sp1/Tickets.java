package threadLearn.xtzaTest.sp1;

/**
 * @author 肖长路
 * @description 票实体类
 * @date 2018年03月17日 14:03
 */
public class Tickets {
    //票号
    public int number = 0 ;
    //总票数
    public int size;
    //表示目前是否有票可售
    public boolean available = false;
    public Tickets(int size){
        this.size = size;
    }
}
