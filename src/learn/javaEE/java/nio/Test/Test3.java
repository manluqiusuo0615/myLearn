package learn.javaEE.java.nio.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-08 9:28
 */
public class Test3 {
    public static void main(String[] args) {
        try {
            //获取通道
            FileInputStream fileInputStream = new FileInputStream("D:\\数据库查询解锁样式.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\数据库查询解锁样式.txt",true);
            FileChannel fileChannel = fileInputStream.getChannel();
            FileChannel fileChannel1 = fileOutputStream.getChannel();
            
            ByteBuffer byteBuffer = ByteBuffer.allocate(50);

            System.out.println("容量值:"+byteBuffer.capacity());
            System.out.println("限制值:"+byteBuffer.limit());
            System.out.println("位置值:"+byteBuffer.position());
            System.out.println("开始之前，容量=限制  位置为0"); 
            //从通道中读取数据，输出到缓冲区
            while(fileChannel.read(byteBuffer)!=-1){
                byteBuffer.flip();
                //从缓冲区中把数据获取  并在控制台输出
                while(byteBuffer.hasRemaining()){
                    System.out.print((char)byteBuffer.get());
                }
                byteBuffer.clear();
            }
            System.out.println("==============");

            byteBuffer.compact();
            //从缓冲区获取数据向通道中写入
            byteBuffer.flip();
            System.out.println("容量值:"+byteBuffer.capacity());
            System.out.println("限制值:"+byteBuffer.limit());
            System.out.println("位置值:"+byteBuffer.position());
            
            byteBuffer.put("aaaaaaaaaaaaaaaaaaaaaaaaaa".getBytes());
            byteBuffer.flip();
            while(fileChannel1.write(byteBuffer)!=-1){

            }
                    























        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            

        }


    }
}
