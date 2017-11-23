package learn.javaEE.java.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 19:09
 */
public class InvokeTester {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    InvokeTester(){

    }

    InvokeTester(String string){
        string = "11111111111111111111111";
    }

    public int add(int a, int b) {
        return a + b;
    }

    public String echo(String message) {
        return "hello:" + message;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //Class<?> clazz = Class.forName("learn.javaEE.java.lang.reflect.InvokeTester");
        Class<?> clazz = InvokeTester.class;
        Object invokeTester = clazz.newInstance();
        //System.out.println(invokeTester instanceof InvokeTester);
        Method method = clazz.getMethod("add",new Class[]{int.class,int.class});
        Object result = method.invoke(invokeTester,new Object[]{1,2});
        System.out.println((Integer) result);
        System.out.println("=================================");
        Method echoMethod = clazz.getMethod("echo",new Class[]{String.class});

        Object result1 = echoMethod.invoke(invokeTester,new Object[]{"张三"});
        System.out.println((String)result1);
        System.out.println("=================================");
//        Method[] methods = clazz.getDeclaredMethods();
//        Constructor constructor = clazz.getConstructor();
//        System.out.println(constructor.getName());
//        System.out.println(constructor.getParameterCount());
//        Field[] fields = clazz.getDeclaredFields();
    }
}
