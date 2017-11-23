package learn.Design_Pattern.Proxy_Pattern.test1;

/**
 * @author 肖长路
 * @Description 真是角色
 * @create 2017-09-19 16:19
 */
public class RealSubject extends Subject{
    @Override
    public void request() {
        System.out.println("From real subject.=====这是真实角色执行的操作...");
    }
}
