package learn.javaEE.java.nio.ByteBuffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-14 20:33
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try {
            FileChannel fileChannel = new FileOutputStream("D:\\nioTest.txt").getChannel();
            fileChannel.write(ByteBuffer.wrap("some text".getBytes()));
            fileChannel.close();

            fileChannel = new FileInputStream("D:\\nioTest.txt").getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
            fileChannel.read(byteBuffer);
            byteBuffer.flip();

            //不再工作
            System.out.println("========="+byteBuffer.asCharBuffer());
            //DECODE USING THIS SYSTEM"S DEFAULT CHARSET:
            byteBuffer.rewind();
            String encoding = System.getProperty("file.encoding");
            System.out.println("***********Decoded using"+encoding+":"+ Charset.forName(encoding).decode(byteBuffer));
            //or we could encode with something that wile print
            fileChannel = new FileOutputStream("D:\\nioTest.txt").getChannel();
            fileChannel.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
            fileChannel.close();
            //now try reading again;
            fileChannel = new FileInputStream("D:\\nioTest.txt").getChannel();
            byteBuffer.clear();
            fileChannel.read(byteBuffer);
            byteBuffer.flip();
            System.out.println("---------------"+byteBuffer.asCharBuffer());
            
            //use a charBuffer to write through
            fileChannel = new FileOutputStream("D:\\nioTest.txt").getChannel();
            byteBuffer = ByteBuffer.allocate(24);
            byteBuffer.asCharBuffer().put("some text");
            fileChannel.write(byteBuffer);
            fileChannel.close();

            //read and display
            fileChannel = new FileInputStream("D:\\nioTest.txt").getChannel();
            byteBuffer.clear();
            fileChannel.read(byteBuffer);
            byteBuffer.flip();
            System.out.println("////////////"+byteBuffer.asCharBuffer());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
