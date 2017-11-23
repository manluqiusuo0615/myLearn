package learn.javaEE.java.lang;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-07 10:26
 */
public class ObjectTest {
    /**
     * 构造方法学习
     */
    private static void ObjectConstructor(){

    }

    private static void MethodTest(){

        System.out.println("========字符串的equals()方法========");
        Object obj1 = new Object();
        Object obj2 = new Object();
        //查看Object的equals方法可以知道
        //Object中的equals方法只是返回
        //当前调用对象  ==  equals（）方法传入的参数
        //this==传入参数
        //==如果左右两侧为引用类型，表示的是两个引用类型的地址是否相同
        //==如果是基本类型，表示的是两个基本类型值是否相同
        //equals()方法表示调用equals（）方法的引用与传进的引用是否一致
        //即两个引用是否指向的是同一个对象。
        //其实Object的equals()方法底层就是==比较
        System.out.println(obj1.equals(obj2));




    }
}
