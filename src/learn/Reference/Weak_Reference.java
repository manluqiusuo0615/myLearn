package learn.Reference;

import java.lang.ref.WeakReference;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 15:39
 */
public class Weak_Reference {
    public static void main(String[] args) {
        Object referent = new Object();
        WeakReference<Object> weakRerference =
                new WeakReference<Object>(referent);
        //判断是否为相同的引用
        System.out.println(referent == weakRerference.get());

        referent = null;
        System.gc();
        //一旦没有指向 referent 的强引用,
        //weak reference 在 GC 后会被自动回收
        //WeakHashMap 使用 WeakReference 作为 key
        //一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
        System.out.println(weakRerference.get() == null);

    }
}
