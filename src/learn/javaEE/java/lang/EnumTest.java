package learn.javaEE.java.lang;

/**
 * @author 肖长路
 * @Description 所有 Java语言枚举类型的公共基本类
 * 其实一定要理解枚举的本源
 * @create 2017-09-18 10:30
 */
public class EnumTest {

    public static void enumMethod(Color str){
        //compareTo()比较此枚举与指定对象的顺序
        //在该对象小于、等于或大于指定对象时，分别返回负整数、零或正整数
        //枚举常量只能与相同枚举类型的其他枚举常量进行比较
        //该方法实现的自然顺序就是声明常量的顺序
        for(Color one: Color.values()){
            System.out.println(one.compareTo(str));
        }
        //返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）
        //被设计用于复杂的基于枚举的数据结构，比如 EnumSet 和 EnumMap。
        for(Color one: Color.values()){
            //%d  是修饰 one.ordinal()  以十进制方式表示
            //%s  是表示one以字符串格式输出
            //%n  换行
            //printf()方法
            System.out.printf("%d,%s,%n",one.ordinal(),one);
        }

    }
    public static void main(String[] args) {
        enumMethod(Color.BLUE);
    }
}

enum Color{

    RED("红色"),WHITE("白色"),
    BLUE("蓝色"),BLACK("黑色");

    private String name;

    public String getName() {
        return name;
    }

    Color(String name){
        this.name = name;
    }
}
