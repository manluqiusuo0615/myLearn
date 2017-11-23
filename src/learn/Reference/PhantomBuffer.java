package learn.Reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author 肖长路
 * @Description 每次申请新的缓存的时候，都要确保之前的字节数组被成功回收。
 * 引用队列的remove方法会阻塞直到虚引用被加入到引用队列中。
 * 不过注意，这种方式可能会导致gc次数过多，程序吞吐量下降。
 * 另外注意，system.gc调用仅仅是建议虚拟机进行回收，并不一定马上会进行gc。
 * @create 2017-09-20 16:10
 */
public class PhantomBuffer {
    private byte[] data = new byte[5];
    private ReferenceQueue<byte[]> queue = new ReferenceQueue<byte[]>();
    private PhantomReference<byte[]> ref = new PhantomReference<byte[]>(data,queue);
    public byte[] get(int size){
        if(size <=0 ){
            throw new IllegalArgumentException("Wrong buffer size");
        }
        if(data.length<size){
            data = null;
            System.gc();
            try {
                //该方法会阻塞直到队列非空
                queue.remove();
                //幽灵引用不会自动清除,需要手动清除
                ref.clear();
                data = new byte[size];
                ref = new PhantomReference<byte[]>(data,queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) {
        PhantomBuffer pb = new PhantomBuffer();
        pb.get(6);

    }
}
