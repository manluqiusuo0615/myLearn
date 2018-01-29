package learn.collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月18日 20:54
 */
public class Test1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","张三");
        map.put("2","张三");
        map.put("3","李四");
        map.put("4","李四");
        map.put("5","王五");
        map.put("6","王五");
        map.put("7","赵六");
        map.put("8","赵六");
        map.put("9","周七");
        map.put("0","周七");

        //for(Map.Entry<String,String> entry:map.entrySet()){
        //    System.out.println("====================");
        //    System.out.println("key:"+entry.getKey());
        //    System.out.println("value:"+entry.getValue());
        //}

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
