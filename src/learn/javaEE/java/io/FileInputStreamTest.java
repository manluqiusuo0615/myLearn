package learn.javaEE.java.io;

import java.io.*;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-07 16:27
 */
public class FileInputStreamTest {
    
    private static void FileInputStreamConstructor(){

    }

    private static void MethodTest(){
        InputStream is = null;
        try {
            File file = new File("D:\\数据库查询解锁样式.txt");
            is = new BufferedInputStream(new FileInputStream(file));

//            is = new FileInputStream("D:\\数据库查询解锁样式.txt");



            byte[] buf = new byte[1024];
            int bytesRead = is.read(buf);
            while(bytesRead != -1){
                for(int i=0;i<bytesRead;i++){
                    System.out.print((char)buf[i]);
                }
                bytesRead = is.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(is != null){
                    is.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileInputStreamTest.MethodTest();
    }
}
