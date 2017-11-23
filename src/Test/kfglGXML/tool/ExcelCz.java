package Test.kfglGXML.tool;

import Test.kfglGXML.entity.XmlEntity;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-19 14:40
 */
public class ExcelCz {
    public static void saveExcel(List<XmlEntity> list,String path){
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("sql照应表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("sql语句ID");
        cell.setCellStyle(style);

        cell = row.createCell((short) 1);
        cell.setCellValue("sql语句");
        cell.setCellStyle(style);


        for(int i=0;i<list.size();i++){
            row = sheet.createRow((int) i + 1);
            XmlEntity one = list.get(i);
            row.createCell(0).setCellValue(one.getSql_id());
            row.createCell(1).setCellValue(one.getSql_content());
        }

        File file = new File(path);
        try {
            FileOutputStream fout = new FileOutputStream(file);
            wb.write(fout);
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
