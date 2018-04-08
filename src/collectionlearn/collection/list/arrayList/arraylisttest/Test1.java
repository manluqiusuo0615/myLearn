package collectionlearn.collection.list.arrayList.arraylisttest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月31日 10:17
 */
public class Test1 {

    public static void main(String[] args) {
        //List<String> list = new ArrayList<String>();
        //list.add("111111111");
        //list.add("222222222");
        //list.add("333333333");
        //list.add(3,"4444444");
        ////
        //System.out.println(list);

        //int[] a = new int[10];
        //int[] a = {1,2,3,4,5};
        //for(int one:a){
        //    System.out.print(one);
        //}
        //System.out.println(a.toString());
        //System.arraycopy(a, 0, a, 1,0);
        //System.out.println();
        //for(int one:a){
        //    System.out.print(one);
        //}





        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.removeIf(s ->s%2==0);
        list.forEach(s ->System.out.println(s));


    }
}
