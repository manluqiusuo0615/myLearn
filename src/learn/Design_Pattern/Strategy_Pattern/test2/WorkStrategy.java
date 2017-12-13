package learn.Design_Pattern.Strategy_Pattern.test2;

import learn.Design_Pattern.Strategy_Pattern.test2.modal.Worker;

import java.util.List;

/**
 * @author 肖长路
 * @description 在策略模式中的接口
 * @date 2017年12月13日 20:28
 */
public interface WorkStrategy {
    public Worker AgeAverage(List<Worker> list);
}
