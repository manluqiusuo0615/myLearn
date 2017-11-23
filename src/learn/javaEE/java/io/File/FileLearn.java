package learn.javaEE.java.io.File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author 肖长路
 * @Description File学习
 * @create 2017-09-28 15:50
 */
public class FileLearn {
    /**
     * 查看目录列表
     * 调用不带参数的File()的list()获取File对象的全部列表
     * 获取受限列表,需要用到"目录过滤器"
     *
     * @param flag
     */
    public void lookDirectoryListing(boolean flag) {
        File file = new File("D:/");
        String[] list;
        if (flag) {
            //返回一个字符串数组
            //这些字符串指定此抽象路径名表示的目录中的文件和目录
            list = file.list();
        } else {
            //list = file.list(new MyDirFileter("[\\S]+?.txt"));
            //showResult(list);
            list = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".xls");
                }
            });
        }
        showResult(list);
    }

    public static void main(String[] args) {
        FileLearn fileLearn = new FileLearn();
        fileLearn.lookDirectoryListing(false);
    }

    /**
     * 忽略大小写排序后输出
     *
     * @param list
     */
    public void showResult(String[] list) {
        //忽略大小写排序
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}

/**
 * 个人文件过滤器
 */
class MyDirFileter implements FilenameFilter {
    private Pattern pattern;

    public MyDirFileter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        //matches() 是否与给定的正则表达式匹配
        return pattern.matcher(name).matches();
    }
}
