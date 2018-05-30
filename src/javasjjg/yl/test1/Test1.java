package javasjjg.yl.test1;

import java.util.Random;

/**
 * @author 肖长路
 * @description
 * @date 2018年05月08日 12:37
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (1+Math.random()*100);
        }
        for(int one:arr){
            System.out.print(one+" ");
        }

        System.out.println("=========================");

        for(int i=0;i<arr.length;i++){
            int one = arr[i];
            int key ;
            for(int j=i+1;j<arr.length-i;j++){
                if(one<arr[j]){
                    key = arr[i];
                    arr[i] = arr[j];
                    arr[j] = key;
                }
            }
        }

        for(int one:arr){
            System.out.print(one+" ");
        }
    }
}
