package learn.javaEE.java.nio.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-07 16:58
 */
public class Test1 {
    public static void main(String[] args) {
        FileChannel fileChannel = null;
        try {
            //获得通道
            fileChannel = new FileInputStream("D:\\数据库查询解锁样式.txt").getChannel();
            //创建一个缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //将字节序列从此通道读入给定的缓冲区
            //返回值读取的字节数，可能为零，如果该通道已到达流的末尾，则返回 -1
            int bytesRead = fileChannel.read(buf);
            System.out.println("读取的字节数:"+bytesRead);

            while(bytesRead!=-1){
                //反转此缓冲区
                buf.flip();
                while(buf.hasRemaining()){//告知在当前位置和限制之间是否有元素
                    System.out.print((char)buf.get());
                }
                //压缩此缓冲区（可选操作）
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(fileChannel != null){
                    fileChannel.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
