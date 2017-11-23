package learn.Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 15:08
 */
public class Generic2<T> {
    private T[] fooArray;

    public void setFooArray(T[] fooArray) {
        this.fooArray = fooArray;
    }

    public T[] getFooArray() {
        return fooArray;
    }

    public static void main(String[] args) {
        Generic2<String> foo = new Generic2<String>();
        String[] strings = {"hello", "world", "well"};
        String[] strings1 = null;

        foo.setFooArray(strings);
        strings1 = foo.getFooArray();

        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }

        Generic2<? extends List<String>> ge = null;
        ge = new Generic2<ArrayList<String>>();
        ge = new Generic2<LinkedList<String>>();

        Generic2<? super List<String>> generic2 = null;
        generic2 = new Generic2<Collection<String>>();
        generic2 = new Generic2<Object>();

        Generic2<? extends Object> g4 = new Generic2();
        Generic2<?> g5 = new Generic2();
        g4.setFooArray(null);
//        g4.setFooArray("1111111");



    }

}
