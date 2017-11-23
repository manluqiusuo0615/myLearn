package learn.javaEE.java.lang.Exception;
/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-09 9:34
 */
public class ExceptionTest2 {
    public void method() throws Exception {
        System.out.println("hello world");
        throw new Exception();
    }

    public static void main(String[] args) {
        ExceptionTest2 test2 = new ExceptionTest2();
        try {
            test2.method();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("11111111111");
        }

    }
}
