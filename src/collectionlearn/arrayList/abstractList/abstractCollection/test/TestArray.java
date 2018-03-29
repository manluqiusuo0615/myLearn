package collectionlearn.arrayList.abstractList.abstractCollection.test;

import java.util.Arrays;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月28日 21:43
 */
public class TestArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        for(int one:arr2){
            System.out.println(one);
        }

    }
}
