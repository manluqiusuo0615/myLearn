package learn.javaEE.java.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 10:56
 */
public class TextFile extends ArrayList<String> {
    /**
     * 从指定文件中读取数据并转换为字符串
     * @param fileName
     * @return
     */
    public static String read(String fileName){
        StringBuffer sb = new StringBuffer();
        try{
            BufferedReader in = new BufferedReader(
                    new FileReader(
                            new File(fileName)));
            try{
                String s;
                while((s=in.readLine())!=null){
                    sb.append(s);
                    //因为在读的过程中换行符会被去除掉
                    sb.append("\n");
                }
            } finally {
                in.close();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
    /**
     * 将字符串写入指定文件中
     * @param fileName
     * @param text
     */
    public static void write(String fileName,String text){
        try{
            PrintWriter out = new PrintWriter(new File(fileName));
            try{
                out.print(text);
            }finally {
                out.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将指定的文件转换为字符串
     * 并将字符串按照指定的  字符串   截取
     * @param fileName
     * @param splitter
     */
    public TextFile (String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")){
            remove(0);
        }
    }

    public TextFile(String fileName){
        this(fileName,"\n");
    }

    /**
     * 将文件中的内容逐行写出
     * @param fileName
     */
    public void write(String fileName){
        try{
            PrintWriter out = new PrintWriter(new File(fileName));
            try{
                for(String item:this){
                    out.println(item);
                }
            }finally {
                out.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = read("D:/nio-data.txt");
        write("D:/test.txt",file);
        TextFile text = new TextFile("D:/test.txt");
        text.write("D:/test2.txt");
        TreeSet<String> words = new TreeSet<String>(new TextFile("D:/nio-data.txt","\\W+"));
        //headSet方法用于返回此set
        //该方法调用返回此set，其元素严格小于toElement的部分视图
        //toElement这是返回集合的高点(不包括)
        //System.out.println(words.headSet("a"));
        Iterator<String> iterator = words.headSet("a").iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
