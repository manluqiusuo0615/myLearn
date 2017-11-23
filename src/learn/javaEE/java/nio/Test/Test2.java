package learn.javaEE.java.nio.Test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-07 19:33
 */
public class Test2 {
    public static void main(String[] args) {
        /**
         * 首先读取数据到Buffer
         * 然后反转Buffer     buf.flip() 的调用
         * 接着再从Buffer中读取数据
         * 标记、位置、限制和容量值遵守以下不变式
         * 0 <= 标记 <= 位置 <= 限制 <= 容量
         */
        try {
            //获取通道
            RandomAccessFile aFile = new RandomAccessFile("D:\\数据库查询解锁样式.txt", "rw");
            FileChannel inChannel2 = aFile.getChannel();
//            FileChannel inChannel = aFile.getChannel();
            //创建缓存区
            ByteBuffer buf = ByteBuffer.allocate(48);
            //将字节序列从此通道读入给定的缓冲区
            //返回值读取的字节数，可能为零，如果该通道已到达流的末尾，则返回 -1
            int bytesRead = inChannel2.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                //使缓冲区为一系列新的通道写入或相对获取 操作做好准备
                //它将限制设置为当前位置，然后将位置设置为 0  limit的值设为position的当前值，再将position的值设为0
                System.out.println("当前位置值:"+buf.position());
                System.out.println("当前限制值:"+buf.limit());
                buf.flip();
                System.out.println("===当前位置值:"+buf.position());
                System.out.println("===当前限制值:"+buf.limit());
                //告知在当前位置和限制之间是否有元素。
                while(buf.hasRemaining()){
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = inChannel2.read(buf);
                System.out.println("*******"+bytesRead);
            }





            //创建缓存区
            ByteBuffer buf2 = ByteBuffer.allocate(4);

            buf2.put("aaaa".getBytes());

            
            inChannel2.write(buf2);
















            aFile.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
