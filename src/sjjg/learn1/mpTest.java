package sjjg.learn1;

/**
 * @author Ф��·
 * @description
 * @date 2018��07��10�� 19:39
 */
public class mpTest {

    private static void mp(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                int temp ;
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int one:arr){
            System.out.print(" "+one);
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,5,1,7,2,54,21,54,77,55,66,88,3,25,14,16,85,44,77};
        mpTest.mp(arr);
    }
}
