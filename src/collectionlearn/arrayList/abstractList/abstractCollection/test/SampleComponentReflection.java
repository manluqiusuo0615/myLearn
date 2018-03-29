package collectionlearn.arrayList.abstractList.abstractCollection.test;

/**
 * @author 肖长路
 * Java的反射机制中通过Class类的getComponentType()方法可以取得一个数组的Class对象
 * 所有的JAVA类都继承自object,那数组也不例外。就是说一个数组本身就是一个class,你得到这个数组的CLASS对象后，可以把它转型为数组。
 * @description
 * @date 2018年03月28日 21:55
 */
public class SampleComponentReflection {
    static void printComponentType(Object array) {
        Class arrayClass = array.getClass();
        String arrayName = arrayClass.getName();
        Class componentClass = arrayClass.getComponentType();
        String componentName = componentClass.getName();
        System.out.println("ArrayClass:"+arrayClass+" ,----ArrayName: " + arrayName + ",------- Component: "
                + componentName);
    }

    public static void main(String[] args) {
        int[] ints = new int[2];
        TestArray[] buttons = new TestArray[6];
        String[][] twoDim = new String[4][5];
        String[] two = new String[4];

        printComponentType(ints);
        printComponentType(buttons);
        printComponentType(twoDim);
        printComponentType(two);
    }

}
