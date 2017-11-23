package learn.javaEE.java.util;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author 肖长路
 * @Description 与枚举类型一起使用的专用 Set 实现
 * 枚举 set 中所有键都必须来自单个枚举类型
 * 该枚举类型在创建 set 时显式或隐式地指定
 * @create 2017-09-18 11:12
 */
public class EnumSetLearn {
    private static void enumSetMethodTest(){
        // of(E e)创建一个最初包含指定元素的枚举 set
        //使用括号中的那些枚举值来去构造EnumSet集合
        EnumSet<FontConstant> enumSet = EnumSet.of(FontConstant.Bold);
        showEnumSet(enumSet);
        System.out.println("=============================");
        //complementOf(EnumSet<E> s)创建一个其元素类型与
        //指定枚举set相同的枚举 set,最初包含指定
        //set中所不包含的此类型的所有元素
        //complement互补的,补充的
        //用给定集合中的枚举数据以外的枚举值构建集合
        showEnumSet(EnumSet.complementOf(enumSet));
        System.out.println("=============================");
        //创建一个具有指定元素类型的空枚举 set。
        EnumSet<FontConstant> enumSet2 = EnumSet.noneOf(FontConstant.class);
        enumSet2.add(FontConstant.Bold);
        showEnumSet(enumSet2);
        System.out.println("=============================");
        List<FontConstant> list = new ArrayList<FontConstant>();
        list.add(FontConstant.Bold);
        list.add(FontConstant.Italilc);
        list.add(FontConstant.Plain);
        //将集合当中的元素拷贝到枚举集合里面去
        //创建一个包含指定元素类型的所有元素的枚举 set
        showEnumSet(EnumSet.copyOf(list));
        System.out.println("=============================");
        //创建一个最初包含由两个指定端点所定义范围内的所有元素的枚举 set
        showEnumSet(EnumSet.range(FontConstant.Bold,FontConstant.Italilc));


        
    }
    public static void main(String[] args) {
        enumSetMethodTest();
    }

    /**
     * 迭代输出枚举集合中的元素
     * @param enumSet
     */
    public static void showEnumSet(EnumSet<FontConstant> enumSet){
        for (Iterator<FontConstant> it = enumSet.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}

/**
 * 枚举类型的类
 */
enum FontConstant{
    Plain("普通字体"),Bold("粗体"),Italilc("斜体");
    private String name;

    public String getName() {
        return name;
    }

    FontConstant(String name){
        this.name = name;
    };


}
