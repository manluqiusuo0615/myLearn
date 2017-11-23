package Test;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 14:33
 */
public class PropertiesTest {
    public static void main(String[] args) {
        Properties p = System.getProperties();
        Set set = p.keySet();
        for(Iterator iterator = set.iterator();iterator.hasNext();){
            String key = (String)iterator.next();
            String value = p.getProperty(key);
            System.out.println(key+"=="+value);
        }
    }
}
