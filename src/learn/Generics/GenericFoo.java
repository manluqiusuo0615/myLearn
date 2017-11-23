package learn.Generics;

/**
 * @author 肖长路
 * @Description 广泛的类型
 * T代表的是一种类型的信息
 * @create 2017-09-18 14:49
 */
public class GenericFoo<T> {
    private T foo;

    public void setFoo(T foo) {
        this.foo = foo;
    }

    public T getFoo() {
        return foo;
    }

    public static void main(String[] args) {
        GenericFoo<Boolean> foo1 = new GenericFoo<Boolean>();
        GenericFoo<Integer> foo2 = new GenericFoo<Integer>();

        foo1.setFoo(true);
        foo2.setFoo(15);

        System.out.println(foo1.getFoo());
        System.out.println(foo2.getFoo());
    }
}
