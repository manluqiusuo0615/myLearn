package objectOptions;

import java.lang.reflect.Field;

/**
 * @Description 对象操作
 * @Author 肖长路
 * @Date 2017年11月20日 15:49
 */
public class ObjectOptions {
    /**
     * @Description 获得传入对象的所有属性的名称
     * @Author 肖长路
     * @Date 2017/11/20 15:55
     */
    public static String[] getPropertysName(Object obj){
        Field[] fields = obj.getClass().getFields();
        int length = fields.length;
        String[] fieldNames = new String[length];
        for(int i=0;i<length;i++){
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

}
