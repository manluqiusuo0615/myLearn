package Test;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-07 14:39
 */
public class Test1 {
    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";
        System.out.print((hello == "Hello") + " ");
        System.out.print((Other.hello == hello) + " ");
        System.out.print((Test.ohter.Other.hello == hello) + " ");
        System.out.print((hello == ("Hel"+"lo")) + " ");
        System.out.print((hello == ("Hel"+lo)) + " ");
        System.out.println(hello == ("Hel"+lo).intern());
    }
}
class Other {
    static String hello = "Hello";
}
