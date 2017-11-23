package Test.kfglGXML.controller;

import Test.kfglGXML.entity.Bdl;
import Test.kfglGXML.tool.FileTool;
import Test.kfglGXML.tool.GetFile;
import Test.kfglGXML.tool.ServiceParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-18 18:57
 */
public class Test {
    public static void main(String[] args) {
        File file = new File("D:\\IDEAWorkSpance\\companyWork\\yx_kfgl\\src\\com");
        List<File> list = new ArrayList<File>();

        GetFile getFile = new GetFile("ervice");
//        GetFile getFile = new GetFile(".xml");



        List<File> service_file = getFile.getFileterFile(file,list) ;

        FileTool fileTool = new FileTool();
        fileTool.setList(service_file);
        fileTool.setNewPath("D:\\tempKFGLService\\");
        fileTool.copyFile();
//        //获取解析后的数据
//        List<Bdl> bdlList = new ArrayList<Bdl>();
//        Bdl bdl = null;
//        for(File one:service_file){
//            BufferedReader br = null ;
//            try {
//                br = new BufferedReader(
//                        new InputStreamReader(
//                                new FileInputStream(one)));
//
//                String line ;
//                while((line = br.readLine())!=null){
//                    String exist = ServiceParser.getDaoName(line);
//
//                    if( null != exist ||!"".equals(exist)){
//                        bdl = new Bdl();
//                        bdl.setDaoName(exist);
//                        bdl.setSqlName(ServiceParser.getSqlName(line));
//                    }
//                    bdlList.add(bdl);
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        for(Bdl one:bdlList){
//            System.out.println(one.getDaoName()+"======="+one.getSqlName());
//        }
    }
}
