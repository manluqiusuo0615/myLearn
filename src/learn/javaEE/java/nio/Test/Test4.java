package learn.javaEE.java.nio.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-08 11:28
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\数据库查询解锁样式.txt", "rw");
            //获取文件通道
            FileChannel fileChannel = randomAccessFile.getChannel();
            //创建缓存区
            ByteBuffer byteBuffer = ByteBuffer.allocate(50);

            while (fileChannel.read(byteBuffer)!=-1){
                //首先将限制设置为当前位置，然后将位置设置为 0。如果已定义了标记，则丢弃该标记。
                //在一系列通道读取或放置 操作之后，调用此方法为一系列通道写入或相对获取 操作做好准备
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.print((char)byteBuffer.get());
                }
                //清除此缓冲区。将位置设置为 0，将限制设置为容量，并丢弃标记。
                //在使用一系列通道读取或放置 操作填充此缓冲区之前调用此方法
                //此方法不能实际清除缓冲区中的数据，但从名称来看它似乎能够这样做，这样命名是因为它多数情况下确实是在清除数据时使用。
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
