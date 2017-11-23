package learn.Reference;

import java.lang.ref.SoftReference;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 15:48
 */
public class Soft_Reference {
    public static void main(String[] args) {
        Object referent = new Object();
        SoftReference<Object> softRerference = new SoftReference<Object>(referent);

        System.out.println(softRerference.get());

        referent = null;
        System.gc();

        /**
         *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用
         */
        System.out.println(softRerference.get());
    }
}
