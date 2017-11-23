package learn.javaEE.java.io.File;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-02 0:01
 */
public class Test4 {

    public static int compute(int number){
        int result = 1 ;
        for(int i=number;i>0;i--){
            result = result*i ;
        }
        return result;
    }

    public static int recursion(int number){
        if(number==1){
            return 1;
        }else{
            return number*recursion(number-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(Test4.compute(10));

        System.out.println(Test4.recursion(10));

    }
}
