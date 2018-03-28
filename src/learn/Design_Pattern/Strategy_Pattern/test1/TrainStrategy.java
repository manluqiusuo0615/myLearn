package learn.Design_Pattern.Strategy_Pattern.test1;

/**
 * @author 肖长路
 * @description 具体策略类(ConcreteStrategy)
 *2：乘坐火车
 * @date 2017年12月13日 20:25
 */
public class TrainStrategy implements TravelStrategy {
    @Override
    public void travelAlgorithm() {
        System.out.println("乘坐火车");
    }
}
