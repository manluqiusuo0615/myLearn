package learn.Design_Pattern.Strategy_Pattern.test1;

/**
 * @author 肖长路
 * @description 具体策略类(ConcreteStrategy)
 *3：骑自行车
 * @date 2017年12月13日 20:26
 */
public class BicycleStrategy implements TravelStrategy {
    @Override
    public void travelAlgorithm() {
        System.out.println("骑自行车");
    }
}
