package learn.enumeration;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 10:14
 */
public class ShowEnum {
    public static void enumCompareTo(OpConstant opConstant){
        System.out.println("====="+opConstant+"=====");
        for(OpConstant one:OpConstant.values()){
            System.out.println("返回的是位置的差值:");
            System.out.println(opConstant.compareTo(one));
            System.out.println("其实比较的是枚举类型谁在前,谁在后");
        }
    }

    public static void main(String[] args) {
        enumCompareTo(OpConstant.valueOf(args[0]));
    }
}
