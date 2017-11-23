package learn.javaEE.java.lang.reflect;

import java.lang.reflect.Method;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 18:55
 */
public class DumpMethods {
    public static void main(String[] args) {
        try {
            //获得字符串所表示的class对象
            Class<?> classType = Class.forName("java.lang.String");
            Method[] methods = classType.getDeclaredMethods();
            for(Method one:methods){
                System.out.println("==========="+one);
                System.out.println(one.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
