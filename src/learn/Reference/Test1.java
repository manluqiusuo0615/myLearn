package learn.Reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 15:57
 */
public class Test1 {
    public static boolean isRun = true;

    @SuppressWarnings("static-access")
    /**
     * 用一个线程检测referenceQueue里面是不是有内容
     * 如果有内容，打印出来queue里面的内容
     * 虚引用的作用是，我们可以声明虚引用来引用我们感兴趣的对象，
     * 在gc要回收的时候，gc收集器会把这个对象添加到referenceQueue，
     * 这样我们如果检测到referenceQueue中有我们感兴趣的对象的时候，
     * 说明gc将要回收这个对象了。
     * 此时我们可以在gc回收之前做一些其他事情，比如记录些日志什么的。
     */
    public static void main(String[] args) throws Exception {
        String abc = new String("abc");
        System.out.println(abc.getClass() + "@" + abc.hashCode());
        final ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
        new Thread() {
            public void run() {
                while (isRun) {
                    //获得容器中的元素
                    Object obj = referenceQueue.poll();
                    if (obj != null) {
                        try {
                            Field rereferent = Reference.class.getDeclaredField("referent");
                            rereferent.setAccessible(true);
                            Object result = rereferent.get(obj);
                            System.out.println("gc will collect："
                                    + result.getClass() + "@"
                                    + result.hashCode() + "\t"
                                    + (String) result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        PhantomReference<String> abcWeakRef = new PhantomReference<String>(abc,referenceQueue);
        abc = null;
        Thread.currentThread().sleep(3000);
        System.gc();
        Thread.currentThread().sleep(3000);
        isRun = false;
    }
}
