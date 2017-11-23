package learn.Design_Pattern.Proxy_Pattern.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 肖长路
 * @Description 该代理类的内部属性是Object类型
 * 实际使用的时候通过该类的构造方法传递进来一个对象
 * 此外,该类还实现了invoke方法,该方法中的method.invoke
 * 其实就是调用被代理对象的将要执行的方法.方法参数是sub
 * 表示该方法从属于sub
 * 通过动态代理,我们可以在执行真实对象的方法前加入自己
 * 的一些额外方法
 * @create 2017-09-19 17:23
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        InvocationHandler handler = new DynamicSubject(realSubject);

        Class<?> classType = handler.getClass();
        //每个代理实例都具有一个关联的调用处理程序.
        //对代理实例调用方法时,将对方法调用进行编码并
        //将其指派到它的调用处理程序的invoke方法.
        //下面的subject就是一个代理实例
        //handler就是它的关联的调用处理程序
        //Proxy.newProxyInstance()方法生成的实例既不是
        //RealSubject实例,也不是DynamicSubject实例
        //它是在运行期间动态所生成的那个类的实例
        //com.sun.proxy.$Proxy0这个类的实例
        //而生成的这个类,它有以下特点,它实现了realSubject.getClass().getInterfaces()
        //这些接口,即realSubject所实现的那些接口
        //System.out.println("************"+realSubject.getClass().getInterfaces().getClass());

        Subject subject =(Subject)Proxy.newProxyInstance(
                        classType.getClassLoader(),
                        realSubject.getClass().getInterfaces(),
                        handler
                );
        //我们在调用subject.request()的时候
        //其实已经转移给了handler了,由handler调用
        //invoke()方法去实现具体操作了
        //subject.cs();
        subject.request();
        System.out.println(subject.getClass());
    }
}
