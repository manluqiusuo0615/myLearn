package annotation20180705;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author 肖长路
 * @description
 * @date 2018年07月04日 19:37
 */
public class Test1 {
    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<>();
        //try {
        //    list.getClass()
        //            .getMethod("add",Object.class)
        //            .invoke(list,"abc");
        //    System.out.println(list.get(0));
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        List<Integer> list = new ArrayList<>();
        list.add(1);

        List<String> list1 = new ArrayList<>();
        list1.add("222222");

        printCollection(list);
        printCollection(list1);

        Vector<? extends Number> x = new Vector<Integer>();
        Vector<? super Integer> y = new Vector<Number>();

        try {
            Method applyMethod = Test1.class.getMethod("applyVector",Vector.class);
            Type[] types = applyMethod.getGenericParameterTypes();
            ParameterizedType pTYpe = (ParameterizedType)types[0];
            System.out.println(pTYpe.getRawType());
            System.out.println(pTYpe.getActualTypeArguments()[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static void printCollection(Collection<?> collection){
        Iterator<?> iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void applyVector(Vector<String> vector){}
}
