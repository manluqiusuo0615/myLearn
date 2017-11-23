package Test.kfglGXML.tool;

import java.io.*;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-19 9:29
 */
public class FileTool {
    private List<File> list;
    private String oldPath;
    private String newPath;

    public List<File> getList() {
        return list;
    }

    public void setList(List<File> list) {
        this.list = list;
    }

    public String getOldPath() {
        return oldPath;
    }

    public void setOldPath(String oldPath) {
        this.oldPath = oldPath;
    }

    public String getNewPath() {
        return newPath;
    }

    public void setNewPath(String newPath) {
        this.newPath = newPath;
    }

    public String copyFile(){
        byte[] buffer = new byte[1000000];

        for(File one:list){
            File newFile = new File(newPath+one.getName());

            FileInputStream fi = null;
            FileOutputStream fo = null;
            try {
                fi = new FileInputStream(one);
                fo = new FileOutputStream(newFile);

                int length = 0 ;
                if((length = fi.read(buffer))!=-1){
                    fo.write(buffer,0,length);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(fi != null){
                    try {
                        fi.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fo != null){
                    try {
                        fo.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "复制操作完成!";
    }

    public void writeFile(File file,String text){
        FileOutputStream fileOutputStream;
        try{
            fileOutputStream = new FileOutputStream(file,true);
            try{
                fileOutputStream.write(text.getBytes());
                fileOutputStream.flush();
            }finally {
                fileOutputStream.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeFile(){

    }
}
