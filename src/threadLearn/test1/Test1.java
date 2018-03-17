package threadLearn.test1;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 11:40
 */
public class Test1 extends Thread {
    @Override
    public void run() {
        System.out.println("重写run方法！");
    }
}
