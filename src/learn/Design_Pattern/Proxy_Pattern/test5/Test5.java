package learn.Design_Pattern.Proxy_Pattern.test5;

import learn.Design_Pattern.Proxy_Pattern.test4.UserService;
import learn.Design_Pattern.Proxy_Pattern.test4.UserServiceImpl;
import learn.Design_Pattern.Proxy_Pattern.test4.UserServiceImpl1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-21 9:00
 */
public class Test5 implements InvocationHandler {

    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }

    public static void main(String[] args) {

        int flag = 1;

        Test5 t = new Test5();
        if (flag == 1) {
            t.setObject(new UserServiceImpl());
        } else if (flag == 2) {
            t.setObject(new UserServiceImpl1());
        }
        
        UserService userService1 = (UserService) Proxy.
                newProxyInstance(
                        t.getClass().getClassLoader(),
                        new Class[]{UserService.class},
                        t);
        userService1.add();


    }
}
