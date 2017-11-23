package Test.kfglGXML.tool;

import org.Filter;
import java.io.File;
import java.util.List;

/**
 * @author 肖长路
 * @Description 获取指定过滤的文件集工具
 * @create 2017-10-18 18:48
 */
public class GetFile {
    private String filter;//过滤  条件

    public GetFile (String filter){
        this.filter = filter;
    }

    public  List<File> getFileterFile(File file,List<File> list){
        File[] files = file.listFiles();
        if (files != null) {
            for (File one : files) {
                if (one.isDirectory()) {// 判断是否文件夹
                    getFileterFile(one,list);
                } else {
                    if(one.getName().indexOf(filter)>0){
                        list.add(one);
                    }
                }
            }
        }
        return list;
    }
}
