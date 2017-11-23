package Test.kfglGXML.tool;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-18 19:07
 */
public class ServiceParser {
    private static Matcher getContent(String regex, String content) {
        //将给定的正则表达式编译并赋予给Pattern类
        //Pattern类的作用在于编译正则表达式后创建一个匹配模式
        Pattern pattern = Pattern.compile(regex);
        //Matcher类使用Pattern实例提供的模式信息对正则表达式进行匹配
        Matcher matcher = pattern.matcher(content);
        return matcher;
    }


    public static String getDaoName(String content) {
        String back = null;
        String daoRegex = "get[\\w\\W]*dao";
        Matcher matcher = getContent(daoRegex, content);
        while (matcher.find()) {
            back = matcher.group();
        }
        return back;
    }

    public static String getSqlName(String content) {
        String back = null;
        String sqlidRegex = "\"[\\w\\W]*\\.[\\w\\W]*?(?=\")";
        Matcher matcher = getContent(sqlidRegex, content);
        while (matcher.find()) {
            back = matcher.group();
        }
        return back;
    }

    public static void main(String[] args) {
        File file = new File("D:\\tempKFGLService");
        File[] files = file.listFiles();

        for (File one : files) {
            try {
                FileReader fr = new FileReader(one);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null) {
                    System.out.println(ServiceParser.getDaoName(line)+"===="+ServiceParser.getSqlName(line));
                     

                }
                br.close();
                fr.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
