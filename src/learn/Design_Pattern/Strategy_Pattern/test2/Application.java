package learn.Design_Pattern.Strategy_Pattern.test2;

import learn.Design_Pattern.Strategy_Pattern.test2.modal.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖长路
 * @description
 * @date 2017年12月13日 20:33
 */
public class Application {
    public static void main(String[] args) {
        List<Worker> list = new ArrayList<Worker>();

        list.add(new Worker(1, "张三", 30));
        list.add(new Worker(2, "李四", 40));
        list.add(new Worker(3, "王五", 33));

        MaxAge findage = new MaxAge();
        findage.SetWorkStrategy(new StrategyMaxAge());
        Worker findw = findage.getFindMax(list);
        System.out.println("年龄最大的工人:"+findw.getId()+"  "+findw.getName()+"  "+findw.getAge());

    }
}
