package learn.Design_Pattern.Proxy_Pattern.test3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 10:27
 */
public class VectorProxy implements InvocationHandler{

    private Object proxyObj;

    public VectorProxy(Object proxyObj){
        this.proxyObj = proxyObj;
    }

    /**
     * 该方法返回的是一个obj的代理类
     * @param obj
     * @return
     */
    public static Object factory(Object obj){
        Class<?> classType = obj.getClass();
        return Proxy.newProxyInstance(
                classType.getClassLoader(),
                classType.getInterfaces(),
                new VectorProxy(obj)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前..."+method);

        if(null!=args){
            for(Object one:args){
                System.out.println("参数:"+one);
            }
        }
        Object obj = method.invoke(proxyObj,args);

        System.out.println("调用之后..."+method);
        return obj;
    }

    public static void main(String[] args) {
        List v = (List) factory(new Vector());

        System.out.println("===="+v.getClass().getName());

        v.add("肖");
        v.add("嘉");
        v.add("兴");
        //打印V其实相当于调用了v的toString方法
        
        System.out.println(v);

        v.remove(0);

        System.out.println(v);

//        Collection c = (Collection) factory(new Vector());
//
//        c.add("1111");
//
//        System.out.println(c);


    }
}
