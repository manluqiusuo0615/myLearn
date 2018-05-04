package exception.test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author 肖长路
 * @description
 * @date 2018年05月04日 10:12
 */
public class ExceptionTest03 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis=new FileInputStream("c:/ab.txt");
    }
}
