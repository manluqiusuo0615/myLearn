package learn.Reference;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 15:32
 */
public class Strong_Reference {
    public static void main(String[] args) {
        Object referent = new Object();
        //通过赋值创建 StrongReference
        Object strongReference = referent;
        //判断是否为相同的引用
        System.out.println(referent == strongReference);

        referent = null;
        System.gc();
        //StrongReference 在 GC 后不会被回收
        System.out.println(strongReference == null);
    }
}
