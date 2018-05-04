package exception.test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 肖长路
 * @description
 * @date 2018年05月04日 10:21
 */
public class ExceptionTest05 {
    public static void main(String[] args){
        try{
            FileInputStream fis=new FileInputStream("c:/ab.txt");
            fis.read();
        }catch(FileNotFoundException e){
            //e内存地址指向的堆中的那个对象是FileNotFoundException类型的事件。
            System.out.println("读取的文件不存在！");
        }catch(IOException e){
            System.out.println("其它IO异常！");
        }
        System.out.println("ABC");
    }
}
