package learn.javaEE.java.lang.Exception;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-09 8:55
 */
public class ExceptionTest {
    public static void main(String[] args) {
        int a = 3;
        int b = 0;
        try {
            System.out.println(a / b);
            System.out.println("异常后可能要执行的代码...");
        } catch (ArithmeticException e) {
            System.out.println("捕获计算异常!");
            //e.printStackTrace();//打印堆栈的跟踪信息
        } finally {
            System.out.println("最终都要执行的结果...");
        }

    }
}
