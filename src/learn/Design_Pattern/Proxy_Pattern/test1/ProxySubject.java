package learn.Design_Pattern.Proxy_Pattern.test1;

/**
 * @author 肖长路
 * @Description 代理角色
 * @create 2017-09-19 16:21
 */
public class ProxySubject extends Subject {

    private RealSubject realSubject;//代理角色内部引用了真实角色

    @Override
    public void request() {
        if (null == realSubject) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void preRequest(){
        System.out.println("真实角色执行之前代角色理执行操作...");
    }

    private void postRequest(){
        System.out.println("真实角色执行完成之后代理角色执行操作...");
    }
}
