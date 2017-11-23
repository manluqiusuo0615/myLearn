package learn.javaEE.java.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-19 9:40
 */
public class ReflectTester {
    /**
     * 首字母大写
     *
     * @param name
     * @return
     */
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

    /**
     * 获取一个类中的get方法
     *
     * @param clazz
     * @param methodName
     * @return
     */
    public static Method getGetMethod(Class<?> clazz, String methodName) {
        Method method = null;
        try {
            method = clazz.getMethod(methodName, new Class[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return method;
    }

    /**
     * 获取一个类中set方法
     *
     * @param clazz
     * @param methodName
     * @param fileType
     * @return
     */
    public static Method getSetMethod(Class<?> clazz, String methodName, Class... fileType) {
        Method method = null;
        try {
            method = clazz.getMethod(methodName, fileType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return method;
    }

    /**
     * 该方法实现对Cunstomer对象的拷贝操作
     *
     * @param object 将要被拷贝的对象
     * @return objectCopy 拷贝后的对象
     */
    public Object copy(Object object) throws Exception {
        Class<?> classType = object.getClass();
        Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
        //获取对象的所有成员变量
        Field[] fields = classType.getDeclaredFields();
        for (Field field : fields) {//给属性值赋值
            String name = field.getName();
            String new_name = captureName(name);
//            System.out.println(new_name);
            String setMethodName = "set" + new_name;
            String getMethodName = "get" + new_name;
//            System.out.println("set方法的名字:"+setMethodName+"====get方法的名字:"+getMethodName);
            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            Method setMethod = classType.getMethod(setMethodName, field.getType());
            //执行get方法,获取object中的get方法的返回值
            Object getValue = getMethod.invoke(object, new Object[]{});
            //将object中的get方法返回的值,
            //作为参数传入objectCopy中的set方法中====实现给objectCopy的属性赋值
            Object setValue = setMethod.invoke(objectCopy, new Object[]{getValue});
//            Object getValue = getGetMethod(classType,getMethodName).invoke(object,new Object[]{});
//            Object setValue = getSetMethod(classType,setMethodName)
//                    .invoke(objectCopy,new Object[]{getValue});

        }
        return objectCopy;
    }

    public static void main(String[] args) throws Exception {
        ReflectTester reflectTester = new ReflectTester();
//        reflectTester.copy(new Cunstomer());
        Cunstomer cunstomer = new Cunstomer("tom", 25);
        cunstomer.setId(1L);

        Cunstomer cunstomer1 = (Cunstomer) reflectTester.copy(cunstomer);
        System.out.println("拷贝对象信息:ID为:" + cunstomer1.getId() + "姓名为:" + cunstomer1.getName() + "年龄为:" + cunstomer1.getAge());

        System.out.println("原始对象:" + cunstomer);
        System.out.println("拷贝对象:" + cunstomer1);
    }

}

class Cunstomer {

    public Cunstomer() {
    }

    public Cunstomer(String name, int age) {
        this.age = age;
        this.name = name;
    }

    private Long id;
    private String name;
    private int age;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
