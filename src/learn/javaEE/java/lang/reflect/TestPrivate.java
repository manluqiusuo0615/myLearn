package learn.javaEE.java.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-19 14:21
 */
public class TestPrivate {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("learn.javaEE.java.lang.reflect.PrivateTest");
            Constructor constructor = clazz.getConstructor(new Class[]{});
            PrivateTest privateTest = (PrivateTest)constructor.newInstance(new Object[]{});

            Method private_mathod = clazz.getDeclaredMethod("syaHello",new Class[]{String.class});
            private_mathod.setAccessible(true);//取消 Java 语言访问检查
            String back = (String) private_mathod.invoke(privateTest,new Object[]{"张三"});

            System.out.println(back);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
