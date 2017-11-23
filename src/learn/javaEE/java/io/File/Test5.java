package learn.javaEE.java.io.File;

import java.io.File;
import java.util.ArrayList;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-04 16:22
 */
public class Test5 {

    private static int time;//文件或目录所处的层次

    public static void deepList(File file){
        if(file.isFile()||file.list().length<=0){
//            time = 0 ;
            return ;
        }else{
            File[] files = file.listFiles();
            files = sort(files);

            for(File one:files){
                StringBuffer sb = new StringBuffer();
                if(one.isFile()){
                    sb.append(getTabs(time));
                    sb.append(one.getName());
                }else{
                    sb.append(getTabs(time));
                    sb.append(one.getName());
                    sb.append("\\\\\\\\\\");
                }
                System.out.println(sb);
                if(one.isDirectory()){
                    time++;
                    deepList(one);
                    time--;
                }
            }
        }
    }

    /**
     * 整理文件数组,使得目录排在文件之前
     * @param files
     * @return
     */
    public static File[] sort(File[] files){
        ArrayList<File> sorted = new ArrayList<File>();
        //寻找到所有的目录
        for(File one:files){
            if(one.isDirectory()){
                sorted.add(one);
            }
        }
        //寻找到所有的文件
        for(File one:files){
            if(one.isFile()){
                sorted.add(one);
            }
        }
        return sorted.toArray(new File[files.length]);
    }

    private static String getTabs(int time){
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<time;i++){
            buffer.append("\t");
        }
        return buffer.toString();
    }
    public static void main(String[] args) {
        File file = new File("D:\\apache-tomcat-6.0.43");
        deepList(file);
    }
}
