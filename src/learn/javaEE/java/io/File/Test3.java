package learn.javaEE.java.io.File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-01 23:42
 */
public class Test3 {
    public static void main(String[] args) {
        File file = new File("D:/wwwwwwwwwwwwww");
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.endsWith(".java")){
                    return true;
                }
                return false;
            }
        });

        for(File one:files){
            System.out.println(one.getName());
        }
        
        
    }
}
