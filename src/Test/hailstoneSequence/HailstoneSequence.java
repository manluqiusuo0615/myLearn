package Test.hailstoneSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-08 15:58
 */
public class HailstoneSequence {

    private static List<Integer> hailstone(int n){
        List<Integer> list = new ArrayList<Integer>();
        //从输入的数字开始
        //按照规则进行生成序列
        //直到n为1
        while(1<n){
            list.add(n);//向集合中添加生成的数
            if(n%2 == 0){//偶数
                n = n/2;
            }else{//奇数
                n = 3*n+1;
            }
        }
        list.add(1);
        return list;
    }
    public static void main(String[] args) {
        List<Integer> list = HailstoneSequence.hailstone(27);
        System.out.println("可以生成的冰雹序列个数为:"+list.size());
        System.out.println("生成的冰雹序列为:"+list);

    }
}
