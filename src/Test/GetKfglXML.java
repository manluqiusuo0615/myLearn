package Test;


import java.io.*;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-18 16:38
 */
public class GetKfglXML {
    public static void main(String[] args) {
//        File file = new File("D:\\IDEA\\Workspaces\\springMVC\\kfgl\\src\\com");
//        List<File> list = new ArrayList<File>();
//
//        GetKfglXML c = new GetKfglXML();
//
//        c.getAllXMLFile(file,list);
//
//        for(File one:list){
//            System.out.println("===="+one.getName());
//        }
//
//        String back = c.copyFile(list,"D:\\tempKFGLXML\\");

        File newFile = new File("D:\\tempKFGLXML\\");
        
        for(File one:newFile.listFiles()){
            StringBuffer stringBuffer = new StringBuffer();
            FileInputStream fs = null;
            BufferedReader br = null ;
            try {
                fs = new FileInputStream(one);
                br = new BufferedReader(new InputStreamReader(fs));

                String line ;
                while((line = br.readLine())!=null){
                    stringBuffer.append(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String sss = XMLParser.firstWay(stringBuffer.toString());
            System.out.println(sss);
        }

    }


    
    private List<File> getAllXMLFile (File file,List<File> list) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File one : files) {
                if (one.isDirectory()) {// 判断是否文件夹
                    getAllXMLFile(one,list);
                } else {
                    if(one.getName().endsWith(".xml")){
                        list.add(one);
                    }
                }
            }
        }
        return list;
    }

    private String copyFile(List<File> list,String newPath){
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

    
}
