package learn.javaEE.java.nio.Test;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-15 16:28
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String,Charset> charSets = Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        while(it.hasNext()){
            String csName = it.next();
            

        }
    }
}
