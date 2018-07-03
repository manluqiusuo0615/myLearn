package Test.kfglGXML.tool;

import Test.kfglGXML.entity.XmlEntity;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.*;

/**
 * @author 肖长路
 * @Description 
 * @create 2017-10-18 19:54
 */
public class XmlReader {

    private List<XmlEntity> list = new ArrayList<XmlEntity>();
    
    public static void main(String[] args) {
        File file = new File("D:\\sfyw");
        File[] files = file.listFiles();

        XmlReader reader = new XmlReader();
        
        for(File one:files){
            reader.listNodes(reader.XmlReader(one));
        }

        ExcelCz.saveExcel(reader.list,"D:\\sfyw.xls");
    }
    private Element XmlReader(File file){
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        Document document;
        Element root = null;
        try {
            //读取文件 转换成Document
            document= reader.read(file);
            //获取根节点元素对象
            root = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return root ;
    }

    public void listNodes(Element node){
        //当前节点下面的所有子节点
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            if(!e.getName().equals("typeAlias")){
                XmlEntity xmlEntity = new XmlEntity();
                xmlEntity.setSql_id(e.attribute("id").getValue());
                xmlEntity.setSql_content(e.getText());
                list.add(xmlEntity);
            }
        }
    }
}
