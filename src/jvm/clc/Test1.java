package jvm.clc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月03日 15:25
 */
public class Test1 {
    public static void main(String[] args) {
        //保持引用，防止自动垃圾回收
        List<String> list = new ArrayList<String>();
        int i = 0;
        while(true){
            System.out.println("11111");
            //通过intern方法向常量池中手动添加常量
            list.add(String.valueOf(i++).intern());
        }
    }
}
