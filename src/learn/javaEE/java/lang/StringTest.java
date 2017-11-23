package learn.javaEE.java.lang;

/**
 * @author 肖长路
 * @Description 字符串操作
 * String 类代表字符串。
 * Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
 * public final class String字符串类是final修饰的，不可改变的。
 * 所以一旦被实例化就无法被修改。
 * 不可变类的实例一旦创建，其成员变量的值就不能被修改。
 *
 * StringPool(字符串池) 字符串池是方法区中的一部分特殊存储。
 * 当一个字符串被被创建的时候，首先会去这个字符串池中查找，
 * 如果找到，直接返回对该字符串的引用。
 * (字符串采用字面值的方式赋值是使用的StringPool操作 例如：String a="";)
 *
 * 字符串池位于栈中  对象位于堆中
 *
 * 对于此类方式   String str = new String("aaa");
 * 当new一个字符串的时候，会先去字符串池中查看是否存在new的字符串值
 * 如果有，就不会在字符串池中创建对应的字符串值。
 *          而是在堆中创建一个对象，并将堆中的对象的地址返回。
 * 如果没有，就在字符串池中创建对应的字符串值，
 *         同时在堆中创建一个字符串对象，并将堆中的对象的地址返回。
 * 就是说不管字符串池中是否存在这个字符串值，堆中一定会创建字符串对象的。
 * @create 2017-09-07 10:26
 */
public class StringTest {
    private int flag;
    private String str_flag;

    private static void StringConstructor() {
        
    }

    private static void MethodTest() {
        String str1 = new String("aaa");
        String str2 = new String("aaa");
        //字符串的equals()方法，重写了Object的equals方法
        //先判断传入的对象和调用对象是否指向相同
        //如果指向相同，就是表示同一个对象；返回true
        //如果指向不同，然后就要判断是否是字符串类型
        //如果不是，直接返回false
        //否则如果是字符串类型，就要进行向下类型转换，将传入的对象强制转为String类型
        //然后将传入的对象与调用对象进行逐个字符的比对。
        //如果有一个不同，就返回false
        //如果全部相同，就返回true
        //字符串的equals()方法==========是判断的字符串内容是否相同
        System.out.println("****"+str1.equals(str2));
        System.out.println("****"+(str1==str2));
        String aa = "aa";
        String bb = "aa";
        System.out.println("****"+aa.equals(bb));
        System.out.println("****"+(aa==bb));


        StringTest st1 = new StringTest();
        StringTest st2 = new StringTest();
        StringTest st3 = new StringTest();
        st1.flag = 1;
        st1.str_flag = "11";
        st2.flag = 1;
        st2.str_flag = "22";
        st3.flag = 3;
        st3.str_flag = "33";
        System.out.println("自定义equals方法:" + st1.equals(st2));
        System.out.println("自定义equals方法:" + st1.equals(st3));

    }


    /**
     * 自定义equals方法
     * @param object
     * @return
     */
    public boolean equals(Object object) {
        if (this == object) {//自己与自己比较
            return true;
        }
        if (object instanceof StringTest) {
            StringTest one = (StringTest) object;
            if (this.flag == one.flag) {//自定义比较方法  flag值一样就说明两个StringTest对象是一样的
                return true;
            } else if (this.str_flag.equals(one.str_flag)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        StringTest.MethodTest();
    }

}
