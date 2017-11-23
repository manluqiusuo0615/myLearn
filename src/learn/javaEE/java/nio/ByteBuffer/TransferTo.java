package learn.javaEE.java.nio.ByteBuffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-14 20:22
 */
public class TransferTo {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("arguments:sourcefile destfile");
            System.exit(1);
        }
        try {
            FileChannel fileChannel = new FileInputStream(args[0]).getChannel(),
                fileChannel1 = new FileOutputStream(args[1]).getChannel();
            //试图读取从此通道的文件中给定 position 处开始的 count 个字节，并将其写入目标通道
            fileChannel.transferTo(0,fileChannel.size(),fileChannel1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
