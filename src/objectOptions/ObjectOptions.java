package objectOptions;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Description 对象操作
 * getFields()与getDeclaredFields()区别:getFields()只能访问类中声明为公有的字段,私有的字段它无法访问，能访问从其它类继承来的公有方法.getDeclaredFields()能访问类中所有的字段,与public,private,protect无关，不能访问从其它类继承来的方法
 * getMethods()与getDeclaredMethods()区别:getMethods()只能访问类中声明为公有的方法,私有的方法它无法访问,能访问从其它类继承来的公有方法.getDeclaredFields()能访问类中所有的字段,与public,private,protect无关,不能访问从其它类继承来的方法
 * getConstructors()与getDeclaredConstructors()区别:getConstructors()只能访问类中声明为public的构造函数.getDeclaredConstructors()能访问类中所有的构造函数,与public,private,protect无关
 * @Author 肖长路
 * @Date 2017年11月20日 15:49
 */
public class ObjectOptions {
    /**
     * @Description 获得传入对象的所有属性的名称
     * @Author 肖长路
     * @Date 2017/11/20 15:55
     */
    public static String[] getPropertysName(Object obj){
        //只能访问类中声明为公有的字段,私有的字段它无法访问，
        //能访问从其它类继承来的公有方法
        Field[] fields = obj.getClass().getFields();

        int length = fields.length;
        String[] fieldNames = new String[length];
        for(int i=0;i<length;i++){
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }
    /**
     * @description 空处理操作
     * @author 肖长路
     * @date 2018/3/28 19:45
     */
    public static <T> T nullOption(T t) throws IllegalAccessException {
        //获取传入类中的所有属性
        Field[] fields = t.getClass().getDeclaredFields();
        for(Field one:fields){
            one.setAccessible(true);
            Object value = one.get(t);
            if(one.getType().equals(String.class)){
                if(value==null){
                    one.set(t,"");
                }
            }
            if(one.getType().equals(Integer.class)){
                if(value==null){
                    one.set(t,0);
                }
            }
        }
        return t;
    }
    /**
     * @description 从其它对象获取指定属性值，赋值给所需对象
     * @param t1 所需对象
     * @param t2 其它对象
     * @param attributes 指定的属性名称数组
     * @return 获取到指定值的对象
     * @author 肖长路
     * @date 2018/3/28 19:40
     */
    public static <T> T assignmentOption(T t1,T t2,String[] attributes){
        for(String one:attributes){
            Field t1Attr;
            Field t2Attr;
            try {
                t1Attr = t1.getClass().getDeclaredField(one);
                t2Attr = t2.getClass().getDeclaredField(one);
                t1Attr.setAccessible(true);
                t2Attr.setAccessible(true);
                Object value = t2Attr.get(t2);
                if(value==null){
                    t1Attr.set(t1,"");
                }else{
                    t1Attr.set(t1,value);
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return t1;
    }
    /**
     *@description: 将一个集合数据转换成指定的对象集合数据
     *@param: fields 属性名称集合
     *@param: values 存储了数据的集合
     *@param: obj 指定的对象
     *@return: java.util.List
     *@author: 肖长路
     *@createTime:2018 年 06 月 27 日 10:14
     */
    //public static List listToObj (List<String> fields,List<List<String>> values,Object obj){
    //
    //
    //}

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Testcc testcc = new Testcc();

        testcc.setC1("掌声");
        testcc.setC2(20);

        Testcc testcc2 = new Testcc();

        String[] arr = {"c1","c2"};
        assignmentOption(testcc2,testcc,arr);
        System.out.println(testcc2.getC1()+"====="+testcc2.getC2());
        //testcc = nullOption(testcc);
        //System.out.println(testcc.getC1());
        //System.out.println(testcc.getC2());
    }
}
