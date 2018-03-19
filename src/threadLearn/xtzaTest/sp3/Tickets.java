package threadLearn.xtzaTest.sp3;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 15:48
 */
public class Tickets {
    public int size;
    /**
     * 存票序号
     */
    public int number=0;
    /**
     * 售票序号
     */
    public int i=0;
    public boolean available=false;
    public Tickets(int size){this.size=size;}
    //同步方法，实现存票的功能
    public synchronized void put(){
        System.out.println("存票的票号:"+(++number));
        available=true;
    }
    //同步方法，实现售票的功能
    public synchronized void sell(){
        if(available==true&&i<number){
            System.out.println("售票的票号:"+(++i));
        }
        if(i==number){
            available=false;
        }
    }

}
