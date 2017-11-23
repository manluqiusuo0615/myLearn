package learn.enumeration;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 9:36
 */
public class ColotTest {
    public static void main(String[] args) {
        Color myColor = Color.Red;
        System.out.println(myColor);

        for(Color one:Color.values()){
            System.out.print(one+"===");
        }
    }
}
