package learn.javaEE.java.lang.reflect;

import java.lang.reflect.Array;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-19 11:29
 */
public class ArrayTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            Object array = Array.newInstance(clazz,10);
            Array.set(array,5,"hello");
            String string = (String) Array.get(array,5);
            System.out.println(string);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
