package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-18 17:32
 */
public class XMLParser {
    private static Matcher getContent(String regex, String content) {
        //将给定的正则表达式编译并赋予给Pattern类
        //Pattern类的作用在于编译正则表达式后创建一个匹配模式
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        //Matcher类使用Pattern实例提供的模式信息对正则表达式进行匹配
        Matcher matcher = pattern.matcher(content);
        return matcher;
    }

    public static String firstWay(String content) {
        StringBuffer back = new StringBuffer();
        String regex = "from[\\s\\S]+?where ";
        Matcher matcher = getContent(regex, content);
        while (matcher.find()) {
            back.append(matcher.group()+"\r\n");
        }
        return back.toString();
    }
}
