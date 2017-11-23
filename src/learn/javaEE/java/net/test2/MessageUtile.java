package learn.javaEE.java.net.test2;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-21 15:11
 */
public class MessageUtile {

    public static String addEnd(String message){
        StringBuffer stringBuffer = new StringBuffer(message);
        stringBuffer.append("==!!");
        return stringBuffer.toString();
    }
}
