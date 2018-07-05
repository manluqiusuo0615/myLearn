package aproxy2080705.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 肖长路
 * @description GuitaiA 实现了 InvocationHandler 这个类
 * @date 2018年07月05日 15:45
 */
public class GuitaiA implements InvocationHandler {
    private Object pingpai;
    public GuitaiA(Object pingpai) {
        this.pingpai = pingpai;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始  柜台是： "+this.getClass().getSimpleName());
        method.invoke(pingpai, args);
        System.out.println("销售结束");
        return null;
    }
}
