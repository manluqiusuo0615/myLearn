package learn.Design_Pattern.Proxy_Pattern.test2;

/**
 * @author 肖长路
 * @Description 真是角色
 * @create 2017-09-19 17:08
 */
public class RealSubject implements Subject{
    @Override
    public void cs() {
        System.out.println("测试==================");
    }

    @Override
    public void request() {
        System.out.println("From real subject.=====这是真实角色执行的操作...");
    }
}
