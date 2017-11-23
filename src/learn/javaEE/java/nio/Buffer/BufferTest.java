package learn.javaEE.java.nio.Buffer;

import java.nio.CharBuffer;
import java.nio.IntBuffer;

/**
 * @Description NIO_缓冲区
 * 缓冲区基础
 *      字节缓冲区：ByteBuffer
 *      字符缓冲区: CharBuffer
 *      等等各种基本类型的缓冲区
 *      缓冲区都提供了读和写的方法get和put方法,也提供了一些
 *      批量的put和get方法
 *      而且缓冲区可以通过allocation创建,此方法通过wrapping
 *      将一个现有(数据类型)数组包装到缓冲区中来为缓冲区内容
 *      分配空间,或者通过创建现有字节缓冲区的视图来创建
 *      缓冲区的操作:
 *      1).存:通过相关Buffer类的put方法进行操作
 *      2).取:通过相关Buffer类的get方法进行操作
 * 创建缓冲区
 *      NIO中有七种主要的缓冲区类,每种都具有一种Java语言中的
 *      非布尔类型的原始数据类型.这些类没有一种能够直接实例化,
 *      他们都是抽象类,但是都包含静态工厂方法用来创建相应类的
 *      新实例,七种缓冲区创建方式基本类似
 *      新的缓冲区是由分配或包装操作创建的.
 *      分配操作创建一个缓冲区对象并分配一个私有的空间来存储容
 *      量大小的数据元素
 *      包装操作创建一个缓冲区对象但是不分配任何空间来存储数据
 *      元素,它使用你所提供的数组作为存储空间来存储缓冲区中的
 *      数据元素
 * 复制缓冲区
 * 概念上,缓冲区是包在一个对象内的基本数据元素数组.
 * Buffer类相比一个简单数组的优点是它将关于数据的
 * 数据内容和信息包含在一个单一的对象中.Buffer类以及它
 * 专有的子类定义了一个用于处理数据缓冲区的API
 * 所有的缓冲区都具有四个属性来提供关于其所包含的数据元素
 * 的信息
 * 容量(Capacity):缓冲区能够容纳的数据元素的最大数量.这一
 * 容量在缓冲时被设定,并且永远不能被改变
 * 上界(Limit):缓冲区的第一个不能被读或写的元素.或者说,
 * 缓冲区中现存元素的计数
 * 位置(Position):下一个要被读或写的元素的索引.位置会自动
 * 由相应的get()和put()函数更新
 * 标记(Mark):一个备忘位置,调用mark()来设定makr=position
 * 调用reset()设定position=makr.标记在设定前是未定义的
 * @Author 肖长路
 * @Date 2017年11月01日 9:58
 */
public class BufferTest {
    public void test1(){
        //分配一个容量为100个char变量的charBuffer
        CharBuffer charBuffer = CharBuffer.allocate(100);
        //依据自己的数组生成缓冲区的备份存储器
        char[] myArray = new char[100];
        CharBuffer charBuffer1 = CharBuffer.wrap(myArray);
        //通过allocate()或wrap()函数创建的缓冲区通常都是间接的
        //间接的缓冲区使用备份数组,通过这些函数获得对这些数组的
        //存取权。
        //Boolean型函数hasArray()告诉你这个缓冲区是否有一个可存
        //取的备份数组.返回如果为true,则array()会返回这个缓冲区
        //对象所使用的数组存储空间的引用。
        //视图缓冲器:一个管理其他缓冲器所包含的数据元素的缓冲器
        //视图缓冲器总是通过调用已存在的缓冲器实例中的函数来创建
        //使用已存在的存储器实例中的工厂方法意味着视图对象为原始
        //存储器的内部实现细节私有.数据元素可以直接存取,无论他们
        //是存储在数组中还是以一些其他的方式.而不需经过原始缓冲区
        //对象的get()/put(),如果原始缓冲区是直接缓冲区,该缓冲区
        //的试图会具有同样的效率优势,映像缓冲区也是如此

    }

    public void test2(){
        //创建指定长度的缓冲区
        IntBuffer buff = IntBuffer.allocate(10);
        System.out.println("缓冲区数据如下:");
        for(int i=0;i<buff.limit();i++){
            System.out.print(buff.get()+"===");
        }
        System.out.println();
        int[] array = new int[]{3,5,9};

        //使用数组来创建一个缓冲区视图
        buff = IntBuffer.wrap(array);
        //利用数组的某一个区间来创建视图
        //buff = IntBuffer.wrap(array,0,1);

        //对缓冲区某个位置上面进行元素修改
        buff.put(0,7);
        System.out.println("原始数组数据如下:");
        for(int one:array){
            System.out.print(one+"=");
        }
        System.out.println();
        System.out.println("缓冲区数据如下:");
        for(int i=0;i<buff.limit();i++){
            System.out.print(buff.get()+"===");
        }
        //flip()方法是为了方便后续再次对buff进行操作
        //buff.flip();//对缓冲区进行反转(limt=pos,pos=0)
        //buff.clear();

        System.out.println("\r\n"+"缓冲区的属性:"+buff);

        //复制一个新的缓冲区
        IntBuffer buff2 = buff.duplicate();
        System.out.println(buff2);
        //System.out.println("缓冲区数据如下:");
        //for(int i=0;i<buff2.limit();i++){
        //    System.out.print(buff2.get()+"===");
        //}
    }

    public static void main(String[] args) {
        BufferTest b = new BufferTest();
        b.test2();
    }
}
