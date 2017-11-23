package learn.javaEE.java.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-28 17:07
 */
public class BufferedInputFile {
    /**
     * 缓冲输入文件
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String read(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuffer stringBuffer = new StringBuffer();
        while ((s = bufferedReader.readLine()) != null) {
            stringBuffer.append(s + "\n");
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }

    /**
     * 从内存输入
     * @throws IOException
     */
    public static void read() throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("D:\\数据库创建表.txt"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(BufferedInputFile.read("D:\\数据库创建表.txt"));

        BufferedInputFile.read();
    }
}
