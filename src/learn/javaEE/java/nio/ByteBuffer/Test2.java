package learn.javaEE.java.nio.ByteBuffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-14 20:10
 */
public class Test2 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
//        if(args.length!=2){
//            System.out.println("arguments:sourcefile destfile");
//            System.exit(1);
//        }
//        try {
//            FileChannel fileChannel = new FileInputStream(args[0]).getChannel(),
//            fileChannel1 = new FileOutputStream(args[1]).getChannel();
//            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
//            while (fileChannel.read(buffer)!=-1){
//                //反转此缓冲区。首先将限制设置为当前位置，
//                // 然后将位置设置为 0。如果已定义了标记，则丢弃该标记。
//                buffer.flip();
//                fileChannel1.write(buffer);
//                buffer.clear();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            FileChannel fr = new FileInputStream("D:\\nioGetTest.txt").getChannel();
            FileChannel fw = new FileOutputStream("D:\\nioPutTest.txt").getChannel();
            ByteBuffer frbb = ByteBuffer.allocate(3);
            System.out.println("=========================");
            System.out.println("frbb1限制大小:" + frbb.limit());
            System.out.println("frbb1位置:" + frbb.position());
            while (fr.read(frbb) != -1) {
                frbb.flip();
                System.out.println("frbb2限制大小:" + frbb.limit());
                System.out.println("frbb2位置:" + frbb.position());
                frbb.clear();
            }
            System.out.println("frbb3限制大小:" + frbb.limit());
            System.out.println("frbb3位置:" + frbb.position());
            System.out.println("=========================");
            System.out.println("fr位置:" + fr.position());

//            ByteBuffer fwbb = ByteBuffer.allocate(3);
//            while(fw.write(fwbb)!=-1){
//                System.out.println("fwbb限制大小:"+fwbb.limit());
//                System.out.println("fwbb位置:"+fwbb.position());
//            }
            System.out.println("fw位置:" + fw.position());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
