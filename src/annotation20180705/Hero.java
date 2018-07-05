package annotation20180705;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 肖长路
 * @description
 * @date 2018年07月05日 14:01
 */
public class Hero {
    @Deprecated
    public void say(){
        System.out.println("Noting has to say!");
    }

    public void speak(){
        System.out.println("I have a dream!");
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.say();
        hero.speak();

        Hero.m(new ArrayList());
    }

    @SuppressWarnings("deprecation")
    public void test1(){
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }
    // Not actually safe!
    @SafeVarargs
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        // Semantically invalid, but compiles without warnings
        array[0] = tmpList;
        // Oh no, ClassCastException at runtime!
        String s = stringLists[0].get(0);
    }
}
