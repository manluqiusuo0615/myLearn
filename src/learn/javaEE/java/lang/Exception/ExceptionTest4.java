package learn.javaEE.java.lang.Exception;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-09 13:54
 */
public class ExceptionTest4 {
    public void method(String str) throws Exception{
        if(null == str){
            throw new MyException("传入的字符串信息不能为空！");
        }else if(str.equals("hello")){
            throw new MyException2("传入的字符串不能为hello！");
        }else{
            System.out.println(str);
        }
    }
    
    public static void main(String[] args) {
        ExceptionTest4 test4 = new ExceptionTest4();
        String str = "hello" ;
        try {
            test4.method(str);
        } catch (Exception e) {
            System.out.println("11111111111");
            System.out.println(e.getMessage());
            //System.out.println(e.toString());
            //e.printStackTrace();
        }finally {
            System.out.println("最终处理结果...");
            System.out.println("异常处理完毕");
        }
        System.out.println("程序执行完毕");
    }

//    public static void main(String[] args) throws MyException {
//        ExceptionTest4 test4 = new ExceptionTest4();
//        test4.method(null);
//    }
}
