package learn.javaEE.java.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-19 14:44
 */
public class Private2 {
    private String name = "张三";

    public String getName() {
        return name;
    }

    public static String captureName(String name) {
        if (Character.isUpperCase(name.charAt(0))) {//判断是否是大写字母
            return name;
        }
        //常规方法截取首字母后转换为大写,再拼接
        //name = name.substring(0, 1).toUpperCase() + name.substring(1);
        //return name;
        //进行ASCII 码前移
        //ASCII 中大写字母从65开始，小写字母从97开始
        //所以这里减去32
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("learn.javaEE.java.lang.reflect.Private2");
            Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});

            //Method cap_method = clazz.getMethod("captureName")

            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);

            field.set(obj,"李四");

//            String setMethodName = "set"+Private2.captureName(field.getName());
//            System.out.println(setMethodName);
//
//            Method setMethod = clazz.getMethod("setMethodName",new Class[]{String.class});
//            setMethod.setAccessible(true);
//            setMethod.invoke(obj,new Object[]{"李四"});
//
            Private2 private2 = (Private2) obj;
            System.out.println(private2.getName());

            System.out.println(Integer.TYPE);
            System.out.println(Integer.class);
            System.out.println(Boolean.TYPE);
            System.out.println(Boolean.class);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
