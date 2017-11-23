package learn.enumeration;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 10:26
 */
public class ShowEnum2 {
    public static void main(String[] args) {
        for(OpConstant one:OpConstant.values()){
            //%d  是修饰 one.ordinal()
            //%s  是表示one以字符串格式输出
            //%n  换行
            System.out.printf("%d,%s,%n",one.ordinal(),one);

        }
    }
}
