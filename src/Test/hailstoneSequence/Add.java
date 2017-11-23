package Test.hailstoneSequence;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-09 12:58
 */
public class Add {

    public static int sum(int a[],int n){
        int sum = 0 ;
        for(int i=0;i<n;i++){
            sum += a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int a[] = {10,5,2,7,6,9,4,5,44,55,88,66,54,25,658,1155,452,3659,1452,4587,25689,1};
        System.out.println(Add.sum(a,5));
    }
}
