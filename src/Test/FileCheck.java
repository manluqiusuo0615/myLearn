package Test;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-15 11:01
 */
public class FileCheck {
    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getStringCellValue(HSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }

    /**
     * 获取单元格数据内容为日期类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getDateCellValue(HSSFCell cell) {
        String result = "";
        try {
            int cellType = cell.getCellType();
            if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
                Date date = cell.getDateCellValue();
                result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
                        + "-" + date.getDate();
            } else if (cellType == HSSFCell.CELL_TYPE_STRING) {
                String date = getStringCellValue(cell);
                result = date.replaceAll("[年月]", "-").replace("日", "").trim();
            } else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
                result = "";
            }
        } catch (Exception e) {
            System.out.println("日期格式不正确!");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据HSSFCell类型设置数据
     *
     * @param cell
     * @return
     */
    private static String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式
                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();
                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);
                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    private static String getAge(String ID) {
        String age;
        if (ID == null || ID.equals("") || ID.equals(" ")) {
            age = "缺失身份证号或身份证有误,无法计算";
        } else {
            int year = Integer.valueOf(ID.substring(6, 10));
            age = String.valueOf((2017 - year));
        }
        return age;
    }

    private void greatMe(int one, int two, String meAge) {
        if (meAge.length() == 2) {
            int ageNum = Integer.valueOf(meAge);
            if (ageNum > 31) {//大于或等于30岁
                one++;
            } else if (ageNum < 31) {
                two++;
            }
        }

    }

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\校责险.xls");
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            int rowNums = hssfSheet.getLastRowNum();
            System.out.println("总行数:" + rowNums);
            List<Person> personList = new ArrayList<Person>();
            for (int i = 4; i < rowNums; i++) {
                HSSFRow one = hssfSheet.getRow(i);
                int cellNums = one.getPhysicalNumberOfCells();
                Person person = new Person();
                for (int j = 0; j < cellNums; j++) {
                    HSSFCell cell = one.getCell(j);
                    String str = getCellFormatValue(cell);
                    if (j == 1) {
                        person.setName(str);
                    } else if (j == 2) {
                        person.setSex(str);
                    } else if (j == 3) {
                        person.setID(str);
                    } else if (j == 5) {
                        person.setElderName(str);
                    } else if (j == 6) {
                        person.setElderSex(str);
                    } else if (j == 7) {
                        person.setElderID(str);
                    }
                }
                personList.add(person);
            }


//            List<Person> boyList = new ArrayList<Person>();
//            List<Person> girlList = new ArrayList<Person>();
//            for(Person one:personList){
//                one.setAge(getAge(one.getID()));
//                one.setElderAge(getAge(one.getElderID()));
//                if(one.getSex().equals("男")){
//                    boyList.add(one);
//                }else{
//                    girlList.add(one);
//                }
//            }

//            for(Person one:boyList){
//                System.out.println(one);
//            }
//            for(Person one:girlList){
//                System.out.println(one);
//            }
            int boyNum = 0;
            int girlNum = 0;
            int count = 0;
            int great30 = 0;
            int less30 = 0;
            int womenNum = 0;
            int manNum = 0;
            int mgreatMe = 0;
            int mlessMe = 0;
            int wgreatMe = 0;
            int wlessMe = 0;
            for (Person one : personList) {
                one.setAge(getAge(one.getID()));
                one.setElderAge(getAge(one.getElderID()));
                System.out.println(one.toString());
                count++;
                if (one.getSex().equals("男")) {
                    boyNum++;
                } else {
                    girlNum++;
                }
                if (one.getElderAge().length() == 2) {
                    int ageNum = Integer.valueOf(one.getElderAge());
                    if (ageNum >= 30) {//大于或等于30岁
                        great30++;
                    } else {
                        less30++;
                    }
                }
                if (one.getElderSex().equals("男")) {
                    if (one.getElderAge().length() == 2) {
                        int ageNum = Integer.valueOf(one.getElderAge());
                        if (ageNum > 31) {//大于或等于30岁
                            mgreatMe++;
                        } else if (ageNum < 31) {
                            mlessMe++;
                        }
                    }
                    //greatMe(mgreatMe,mlessMe,one.getElderAge());
                    manNum++;
                } else {
                    if (one.getElderAge().length() == 2) {
                        int ageNum = Integer.valueOf(one.getElderAge());
                        if (ageNum > 31) {//大于或等于30岁
                            wgreatMe++;
                        } else if (ageNum < 31) {
                            wlessMe++;
                        }
                    }
                    //greatMe(wgreatMe,wlessMe,one.getElderAge());
                    womenNum++;
                }
            }

            System.out.println("班里总人数为:" + count + "人,班里男孩人数为:" + boyNum + "人,班里女孩人数为:" + girlNum + "人.");
            System.out.println("班级中父辈大于或等于30岁的人数量为:" + great30 + "人,班级中父辈大于或等于30岁的人数量为:" + less30 + "人.");
            System.out.println("班里报的母亲的人数为:" + womenNum + "人,班里报的父亲的人数为:" + manNum + "人.");
            System.out.println("小朋友父辈中大于我的人数为:"+mgreatMe+"小朋友父辈中小于我的人数为:"+mlessMe);
            System.out.println("小朋友母亲中大于我的人数为:"+wgreatMe+"小朋友父辈中母亲我的人数为:"+wlessMe);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class Person {
    private String ID;
    private String name;
    private String age;
    private String sex;
    private String elderName;
    private String elderSex;
    private String elderAge;
    private String elderID;

    public String getElderSex() {
        return elderSex;
    }

    public String getElderAge() {
        return elderAge;
    }

    public String getElderID() {
        return elderID;
    }

    public void setElderSex(String elderSex) {
        this.elderSex = elderSex;
    }

    public void setElderAge(String elderAge) {
        this.elderAge = elderAge;
    }

    public void setElderID(String elderID) {
        this.elderID = elderID;
    }

    public String getElderName() {
        return elderName;
    }

    public void setElderName(String elderName) {
        this.elderName = elderName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "身份证号='" + ID + '\'' +
                ", 姓名='" + name + '\'' +
                ", 年龄='" + age + '\'' +
                ", 性别='" + sex + '\'' +
                ", 长辈姓名='" + elderName + '\'' +
                ", 长辈性别='" + elderSex + '\'' +
                ", 长辈年龄='" + elderAge + '\'' +
                ", 长辈身份证号='" + elderID + '\'' +
                '}';
    }
}
