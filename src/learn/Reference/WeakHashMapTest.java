package learn.Reference;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 15:44
 */
public class WeakHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        Map<Object, Object> weakHashMap = new WeakHashMap<Object, Object>();
        Object key = new Object();
        Object value = new Object();
        weakHashMap.put(key, value);

        System.out.println(weakHashMap.containsValue(value));

        key = null;
        System.gc();

        /**
         * 等待无效 entries 进入 ReferenceQueue 以便下一次调用 getTable 时被清理
         */
        Thread.sleep(1000);

        /**
         * 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
         */
        System.out.println(weakHashMap.containsValue(value));
    }
}
