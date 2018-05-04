package exception.test1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 肖长路
 * @description
 * @date 2018年05月04日 10:33
 */
public class AB extends A{
    //public void m1()throws IOException {}
}
class A{
    public void m1()throws FileNotFoundException {}
}
