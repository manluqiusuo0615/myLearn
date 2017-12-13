package Test;

/**
 * @author 肖长路
 * @description 获取一个数组中的最大值
 * @date 2017年12月13日 20:37
 */
public class ArrTest {
    public static void main(String[] args) {
        int[] test = {1,2,3,2,3,2,24,234,4356,234,234,345,4,456,65,7,345,345,456};
        int max = 0 ;
        int[] newArray = new int[test.length];
        for(int i=0;i<test.length;i++){
            newArray[i] = test[i];
            if(newArray[max]<=test[i]){
                max = i ;
            }
        }
        System.out.println(test[max]);
    }
}
