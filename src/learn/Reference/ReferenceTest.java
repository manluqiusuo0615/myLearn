package learn.Reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 15:50
 */
public class ReferenceTest {
    public static void main(String[] args) {
        //test1();//软引用
        //test2();//弱引用
        //test3();//幽灵引用_1
        test4();//幽灵引用_2

    }

    public static void test1() {
        //在堆中创建一个对象Obj
        //在栈中创建一个p来强引用此对象Obj
        Person p = new Person(1);

        //在栈中创建一个softReference来软引用此对象Obj 可以获取对象的属性值
        SoftReference<Person> softReference = new SoftReference<Person>(p);
        System.out.println(p.getId());//输出打印:1
        System.out.println(softReference.get().getId());//输出打印:1

        //断开p和Obj的强引用
        p = null;
        //System.out.println(p.getId());
        //System.gc();
        System.out.println(softReference.get().getId());//输出打印:1
        //并不报空指针异常  虽然断开了p和Obj的强引用,但是并没有被回收.
        //如果在前面调用gc() 垃圾回收  运行结果也是打印1的..软引用只有系统在发生内存溢出异常之前，会把只被软引用的对象进行回收
    }

    public static void test2() {
        //在堆中创建一个对象Obj
        //在栈中创建一个p来强引用此对象Obj
        Person p = new Person(1);

        //在栈中创建一个weakReference来弱引用此对象Obj 可以获取对象的属性值
        WeakReference<Person> weakReference = new WeakReference<Person>(p);
        System.out.println(weakReference.get().getId());//打印输出:1

        //断开p和Obj的强引用
        p = null;
        //System.gc();
        System.out.println(weakReference.get().getId());//打印输出:1
        //p=null 之后 还是可以正常的打印输出1  说明断开强引用和其他弱引用,软引用压根没有关系.
        //如果在打印之前 调用gc() 方法之后  就会报错..java.lang.NullPointerException
        //垃圾回收不论内存是否不足都会回收只被弱引用关联的对象。

    }

    public static void test3() {
        //在堆中创建一个对象Obj
        //在栈中创建一个p来强引用此对象Obj
        Person p = new Person(1);

        //Phantom 幻影幽灵 的意思
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<Person>();
        //在栈中创建一个phantomReference来虚引用此对象Obj 不可以获取对象的属性值
        PhantomReference<Person> phantomReference = new PhantomReference<Person>(p, referenceQueue);
        System.out.println(phantomReference.get().getId());//打印报错 java.lang.NullPointerException
        //直接得不到p对象对应的id值....
        //PhantomReference的唯一作用就是 能在这个对象被收集器回收时收到一个系统通知 看test4()方法
    }

    public static void test4() {

        //在堆中创建一个对象Obj
        //在栈中创建一个p来强引用此对象Obj
        Person p = new Person(1);

        //Phantom 幻影幽灵 的意思
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<Person>();
        //在栈中创建一个phantomReference来虚引用此对象Obj 不可以获取对象的属性值
        PhantomReference<Person> phantomReference = new PhantomReference<Person>(p, referenceQueue);

        //打印输出: null  这个是查询队列中是否有元素.
        System.out.println(referenceQueue.poll());

        //断开p和obj的强引用
        p = null;
        System.gc();//p被回收之后 队列referenceQueue中就有值了.

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //过 一秒钟之后再查询队列中是否有元素.
        //打印输出: java.lang.ref.PhantomReference@77fef1a0
        System.out.println(referenceQueue.poll());
        //PhantomReference的唯一作用就是 能在这个对象被收集器回收时收到一个系统通知
        //如果这个对象被回收了,会把通知放到队列中.

        //如果前面p=null注释掉  再运行打印输出就是  null  因为p没有被回收(强引用中) 就不会把通知放到队列中...队列中为空 null
        //回收的标志就是把通知放到队列中..
    }
}

class Person {
    public Person(Integer id) {
        this.id = id;
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalized!!!!!");
    }
}
