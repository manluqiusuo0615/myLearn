package exception.test1;

/**
 * @author 肖长路
 * @description
 * @date 2018年05月04日 10:11
 */
public class ExceptionTest02 {
    public static void main(String[] args){
        int a=10;
        int b=0;
        if(b!=0){
            int c=a/b;
            System.out.println(a+"/"+b+"="+c);
        }else{
            System.out.println("除数不能为0");
        }
    }
}
