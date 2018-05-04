package exception.test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author 肖长路
 * @description
 * @date 2018年05月04日 10:15
 */
public class ExceptionTest04 {
    public static void main(String[] args){
        try {
            m1();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
    public static void  m1() throws FileNotFoundException {
        m2();
    }
    public static void m2() throws FileNotFoundException {
        m3();
    }
    public static void m3() throws FileNotFoundException {
        //FileInputStream构造方法声明位置上使用throws(向上抛)
        new FileInputStream("c:/ab.txt");
    }
}
