package aproxy2080705.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 肖长路
 * @description
 * @date 2018年07月05日 15:48
 */
public class Test {
    public static void main(String[] args) {
        MaotaiJiu maotaijiu = new MaotaiJiu();
        Wuliangye wuliangye = new Wuliangye();

        Furongwang fu = new Furongwang();

        InvocationHandler jingxiao1 = new GuitaiA(maotaijiu);
        InvocationHandler jingxiao2 = new GuitaiA(wuliangye);

        InvocationHandler jingxiao3 = new GuitaiA(fu);

        SellWine dynamicProxy1 = (SellWine) Proxy.newProxyInstance(
                MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(),
                jingxiao1
        );
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(
                MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(),
                jingxiao2
        );

        dynamicProxy1.mainJiu();
        dynamicProxy2.mainJiu();

        SellCigarette dynamicProxy3 = (SellCigarette) Proxy.newProxyInstance(
                Furongwang.class.getClassLoader(),
                Furongwang.class.getInterfaces(),
                jingxiao3);

        dynamicProxy3.sell();


        System.out.println("dynamicProxy1 class name:"+dynamicProxy1.getClass().getName());
        System.out.println("dynamicProxy2 class name:"+dynamicProxy2.getClass().getName());
        System.out.println("dynamicProxy3 class name:"+dynamicProxy3.getClass().getName());
    }
}
