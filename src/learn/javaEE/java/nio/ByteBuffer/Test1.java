package learn.javaEE.java.nio.ByteBuffer;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-14 19:33
 */
public class Test1 {
    private static final int BSIZE = 1024 ;
    public static void main(String[] args) {
        try {
            FileChannel fileChannel = new FileOutputStream
                    ("D:\\nioTest.txt").getChannel();
//            FileChannel fileChannel = fileChannel = new RandomAccessFile
//                    ("D:\\nioTest.txt","rw").getChannel();
//            System.out.println("文件尾部:"+fileChannel.size());
//            fileChannel.position(fileChannel.size());
            fileChannel.write(ByteBuffer.wrap("55555555555555".getBytes()));
            fileChannel.close();

            fileChannel = new RandomAccessFile("D:\\nioTest.txt","rw").getChannel();
            //指针移动到最后
            fileChannel.position(fileChannel.size());
            fileChannel.write(ByteBuffer.wrap("66666666666666666".getBytes()));
            fileChannel.close();

            fileChannel = new FileInputStream("D:\\nioTest.txt").getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
            fileChannel.read(byteBuffer);
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                System.out.println((char)byteBuffer.get());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
