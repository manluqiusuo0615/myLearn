package learn.Design_Pattern.Proxy_Pattern.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-19 17:11
 */
public class DynamicSubject implements InvocationHandler{

    private Object sub;

    DynamicSubject(Object obj){
        this.sub = obj;
    }


    @Override
    /**
     * proxy这个对象是代理这个实例本身
     * com.sun.aproxy2080705.$Proxy0这个类的实例
     * method要去调用的真实对象的那个方法的Method对象
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前"+proxy.getClass());
        System.out.println("调用之前:"+method);

        method.invoke(sub,args);

        System.out.println("调用之后"+proxy.getClass());
        System.out.println("调用之后:"+method);
        
        return null;
    }
}
