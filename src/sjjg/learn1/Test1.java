package sjjg.learn1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ф��·
 * @description
 * @date 2018��07��06�� 17:22
 */
public class Test1 {

    public static int getHailstoneLength(int num){
        List<Integer> list = new ArrayList<>();
        list.add(num);
        int length = 1;
        while(1<num){
            if(num%2!=0){
                num=3*num+1;
            }else{
                num=num/2;
            }
            list.add(num);
            length++;
        }
        for(Integer one:list){
            System.out.print(" "+one+" ");
        }
        return length;
    }
    public static void main(String[] args) {
        System.out.println("����Ϊ:"+getHailstoneLength(27));
    }
}
