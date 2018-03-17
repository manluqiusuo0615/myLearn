package threadLearn.xtzaTest;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月17日 12:58
 */
public class FactorialThread2 implements Runnable {
    private int num;
    public FactorialThread2(int num){
        this.num = num;
    }
    @Override
    public void run() {
        int i=num;
        int result = 1;
        System.out.println("new thread started");
        while(i>0){
            result = result*i;
            i = i-1;
        }
        System.out.println("The factorial of "+num+" is "+result);
        System.out.println("new thread ends");
    }
}
