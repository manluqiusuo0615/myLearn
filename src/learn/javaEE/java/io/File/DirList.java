package learn.javaEE.java.io.File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-28 15:57
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File("D:/");
        String[] list;
        if(args.length == 0){
            list = path.list();
            //忽略大小写排序
            Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
            for(String dirItem:list){
                System.out.println(dirItem);
            }
        }else{
            list = path.list(new DirFileter(args[0]));
            Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
            for(String dirItem:list){
                System.out.println(dirItem);
            }
        }
    }
}

/**
 * 该过滤类的作用
 * 就是将accept()方法提供给list使用
 * 此处应用了策略模式
 * 策略模式的目的就是提供了代码行为的灵活性
 */
class DirFileter implements FilenameFilter{
    private Pattern pattern;
    public DirFileter(String regex){
        this.pattern = Pattern.compile(regex);
    }

    /**
     *
     * @param dir 特定文件所在目录的File对象
     * @param name 该特定文件的文件名称
     * @return
     */
    public boolean accept(File dir,String name){
        return pattern.matcher(name).matches();
    }
}
