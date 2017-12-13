package learn.Design_Pattern.Strategy_Pattern.test2;

import learn.Design_Pattern.Strategy_Pattern.test2.modal.Worker;

import java.util.List;

/**
 * @author 肖长路
 * @description 具体策略是实现WorkStrategy接口的类
 * @date 2017年12月13日 20:32
 */
public class StrategyMaxAge implements WorkStrategy {
    @Override
    public Worker AgeAverage(List<Worker> list) {
        int fs[] = new int[list.size()];
        int maxage = 0;
        for (int j = 0; j < list.size(); j++) {
            fs[j]=list.get(j).getAge();
            if (fs[maxage] <= fs[j]) {
                maxage = j;
            }
        }
        return list.get(maxage);
    }
}
