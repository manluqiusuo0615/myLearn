package learn.javaEE.java.io.File;

import java.io.File;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-01 23:28
 */
public class Test2 {
    public static void main(String[] args) {
        File file = new File("D:\\apache-maven-3.3.9");
//        String[] fileNames = file.list();
//        for(String fileName : fileNames){
//            System.out.println(fileName);
//        }

        File[] files = file.listFiles();
        for(File one:files){
            System.out.println(one.getName());
            //System.out.println("===="+one.getParentFile().getName());
            if(one.getName().equals("settings.xml.bak")){
                one.delete();
            }
        }
        
    }
}
