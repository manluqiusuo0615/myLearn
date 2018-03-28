package collectionlearn.iterable.test;

/**
 * @author 肖长路
 * @description
 * @date 2018年03月27日 15:34
 */
public interface I1 {
    void test1();
    void test2();
    default void test3(){
        System.out.println("ssss1");
    }
}
