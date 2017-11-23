package learn.Generics;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 15:26
 */
public class WrapperFoo<T> {
    private GenericFoo3<T> foo;

    public void setFoo(GenericFoo3<T> foo) {
        this.foo = foo;
    }

    public GenericFoo3<T> getFoo() {
        return foo;
    }

    public static void main(String[] args) {
        GenericFoo3<Integer> foo = new GenericFoo3<Integer>();
        foo.setFoo(new Integer(-10));

        WrapperFoo<Integer> wrapperFoo = new WrapperFoo<Integer>();
        wrapperFoo.setFoo(foo);

        GenericFoo3<Integer> genericFoo3 = wrapperFoo.getFoo();
        System.out.println("=========="+genericFoo3.getFoo());
    }
}

class GenericFoo3<T>{
    private T foo;

    public void setFoo(T foo) {
        this.foo = foo;
    }

    public T getFoo() {
        return foo;
    }
}
