package learn.Design_Pattern.Strategy_Pattern.test1;

/**
 * @author 肖长路
 * @description 具体策略类(ConcreteStrategy)
 * 乘坐飞机
 * @date 2017年12月13日 20:24
 */
public class AirPlanelStrategy implements TravelStrategy {
    @Override
    public void travelAlgorithm() {
        System.out.println("乘坐飞机");
    }
}
