package chatting_software.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-22 11:33
 */
public class CheckUtil {
    /**
     * 是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是整数
     *
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 判断字符串是否为整数
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        if(str.toCharArray()[0]!=0){
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {

//        System.out.println(CheckUtil.isNum("032"));
//        System.out.println(CheckUtil.isNum("26s"));

//        System.out.println(CheckUtil.isInteger("038"));
//        System.out.println(CheckUtil.isInteger("23.5"));
//        System.out.println(CheckUtil.isInteger("s5"));
    }
}
