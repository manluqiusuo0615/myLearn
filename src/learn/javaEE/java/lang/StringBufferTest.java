package learn.javaEE.java.lang;

/**
 * @author 肖长路
 * @Description 线程安全的可变字符序列
 * 因为final修饰，所以该类不能被继承
 * 一个类似于 String 的字符串缓冲区，但不能修改
 * 虽然在任意时间点上它都包含某种特定的字符序列，但通过某些方法调用可以改变该序列的长度和内容
 * 不同于字符串，创建后再追加值，相当于重新创建新对象。
 * StringBuffer可以任意追加字符串对象，最后只有一个StringBuffer对象。
 * @create 2017-09-07 14:46
 */
public class StringBufferTest {

    private static void StringBufferConstructor(){
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.hashCode());
        sb.append("hello").append(true).append(112);

        System.out.println(sb);
        System.out.println(sb.hashCode());
        
    }

    private static void MethodTest(){
        
    }

    public static void main(String[] args) {
        StringBufferConstructor();
        
    }
    
}
