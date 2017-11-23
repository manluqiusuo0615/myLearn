package learn.Design_Pattern.Proxy_Pattern.test4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 11:02
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;//目标对象

    public MyInvocationHandler(Object target){
        this.target=target;
    }

    /**
     * 获得代理对象
     * 一个类加载器
     * 一个真实对象的接口
     * 一个与该代理类关联的代理处理器
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),this.target.getClass().getInterfaces(),this);
    }
    
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------------------before------------------");
        Object result = method.invoke(target,args);
        System.out.println("-------------------after------------------");
        return result;
    }

    public static void main(String[] args) {
        UserServiceImpl msi = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(msi);
        UserService userService = (UserService) myInvocationHandler.getProxy();
        userService.add();
    }
}
