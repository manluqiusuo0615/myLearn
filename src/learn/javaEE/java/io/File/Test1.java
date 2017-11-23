package learn.javaEE.java.io.File;

import java.io.File;
import java.io.IOException;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-01 22:48
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        //File file = new File("D:\\newTest1.txt");
        File file = new File("D:/newTest1/test1");
        File file1 = new File(file,"test1.txt");
        if(!file.exists()){
            file.mkdirs();
        }
        if(!file1.exists()){
            file1.createNewFile();
        }


        System.out.println("是否是一个目录:"+file.isDirectory());
        System.out.println("是否是一个文件:"+file1.isFile());
    }
}
