package learn.Design_Pattern.Strategy_Pattern.test2;

import learn.Design_Pattern.Strategy_Pattern.test2.modal.Worker;

import java.util.List;

/**
 * @author 肖长路
 * @description 上下文面向策略,既是面向接口的类
 * @date 2017年12月13日 20:31
 */
public class MaxAge {
    WorkStrategy workstrategy;
    public void SetWorkStrategy(WorkStrategy workstrategy){
        this.workstrategy=workstrategy;
    }
    public Worker getFindMax(List<Worker> list){
        if(workstrategy!=null){
            return workstrategy.AgeAverage(list);
        }else{
            return null;
        }
    }
}
