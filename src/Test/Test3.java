package Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-09 15:41
 */
public class Test3 {
    

    public void he(){
        System.out.println("hello");
    }


    public static void getSql(Object obj){
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getMethods();
        for(Method one:methods){
            //boolean exists = one.isAnnotationPresent(Test.class);
            //if(exists){
            //    try {
            //        one.invoke(obj);
            //    } catch (IllegalAccessException e) {
            //        e.printStackTrace();
            //    } catch (InvocationTargetException e) {
            //        e.printStackTrace();
            //    }
            //}
        }
    }
    public static void main(String[] args) {

    }
}
