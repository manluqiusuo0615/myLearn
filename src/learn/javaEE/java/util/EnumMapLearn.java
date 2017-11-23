package learn.javaEE.java.util;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author 肖长路
 * @Description EnumMap与枚举类型键一起使用的专用 Map 实现
 * 枚举映射中所有键都必须来自单个枚举类型，
 * 该枚举类型在创建映射时显式或隐式地指定。
 * 枚举映射在内部表示为数组。此表示形式非常紧凑且高效。
 * 枚举映射根据其键的自然顺序 来维护（该顺序是声明枚举常量的顺序）
 * 
 * @create 2017-09-18 11:42
 */
public class EnumMapLearn {

    public static void enumMapLearnMethodTest(){
        //这个构造方法没有不接受参数的构造
        Map<Action,String> map = new EnumMap<Action,String>(Action.class);
        map.put(Action.TURN_LEFT,"向左转");
        map.put(Action.TURN_RIGHT,"向右转");
        map.put(Action.SHOOT,"射击");

        for(Action one:Action.values()){
            System.out.println(map.get(one));
        }
    }

    public static void main(String[] args) {
        enumMapLearnMethodTest();
    }
}

enum Action{
    TURN_LEFT,
    SHOOT,
    TURN_RIGHT;
}
