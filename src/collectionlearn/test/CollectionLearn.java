package collectionlearn.test;

import java.util.*;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月27日 9:04
 */
public class CollectionLearn {
    private List<String> list = new ArrayList<String>();

    private HashSet<String> hashSet = new HashSet<String>();

    private HashMap<Integer,String> hashMap = new HashMap<Integer,String>();

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"a");
        map.put(2,"a");
        map.put(3,"b");
        map.put(4,"c");
        map.put(5,"d");
        map.put(6,"e");
        map.put(7,"b");
        map.put(8,"c");
        map.put(9,"f");
        map.put(0,"h");

        //System.out.println("第一种方法:");
        //for (Map.Entry<Integer,String> one:map.entrySet()){
        //    System.out.println(one.getKey()+"===="+one.getValue());
        //}
        System.out.println("第二种方法:");
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> one = iterator.next();
            System.out.println(one.getKey()+"===="+one.getValue());
        }
        //System.out.println("第三种方法:");
        //Set<Integer> set = map.keySet();
        //for(Integer one:set){
        //    System.out.println(one+"===="+map.get(one));
        //}
    }
}
