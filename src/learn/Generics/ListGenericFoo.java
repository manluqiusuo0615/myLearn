package learn.Generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 15:41
 */
public class ListGenericFoo<T extends List<Integer>> {

    private T[] fooArray;

    public void setFooArray(T[] fooArray) {
        this.fooArray = fooArray;
    }

    public T[] getFooArray() {
        return fooArray;
    }

    public static void main(String[] args) {
        ListGenericFoo<LinkedList<Integer>> fool = new ListGenericFoo<LinkedList<Integer>>();
        ListGenericFoo<ArrayList<Integer>> fool1 = new ListGenericFoo<ArrayList<Integer>>();

        LinkedList<Integer>[] linkedLists = new LinkedList[10];
        ArrayList<Integer>[] arrayLists = new ArrayList[10];

        fool.setFooArray(linkedLists);
        fool1.setFooArray(arrayLists);

    }
}
