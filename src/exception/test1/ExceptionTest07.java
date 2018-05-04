package exception.test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author 肖长路
 * @description
 * @date 2018年05月04日 10:28
 */
public class ExceptionTest07 {
    //public static void main(String[] args){
    //    try{
    //        FileInputStream fis = new FileInputStream("c:/ab.txt");
    //    }catch(FileNotFoundException e){
    //        //打印异常堆栈信息
    //        //一般情况下都会使用该方式去调试程序
    //        e.printStackTrace();
    //    }
    //    //这段代码会执行
    //    System.out.println("ABC");
    //}
    public static void main(String[] args){
        try{
            FileInputStream fis = new FileInputStream("c:/ab.txt");
        }catch(FileNotFoundException e){
            String msg=e.getMessage();
            System.out.println(msg);
        }
        System.out.println("ABC");
    }
}
