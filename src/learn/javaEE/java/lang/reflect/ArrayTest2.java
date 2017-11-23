package learn.javaEE.java.lang.reflect;

import java.lang.reflect.Array;
/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-19 11:33
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        int[] dims = new int[]{3,2,1};
        //创建的三维数组
        //创建一个具有指定的组件类型和维度的新数组
        Object array = Array.newInstance(Integer.TYPE,dims);
        //返回指定数组对象中索引组件的值
        Object arrayObj = Array.get(array,2);

        Class<?> classType = arrayObj.getClass().getComponentType();
        //System.out.println(classType);

        arrayObj = Array.get(arrayObj,1);

        Array.setInt(arrayObj,0,37);

        int[][][]  arrayCast = (int[][][]) array;

        //System.out.println(arrayCast[2][1][0]);

        for(int i=0;i<arrayCast.length;i++){
            int[][] one = arrayCast[i];
            for(int j=0;j<one.length;j++){
                int[] two = one[j];
                for(int k=0;k<two.length;k++){
                    int three = two[k];
                    System.out.println(three);
                }
            }
        }
    }
}
