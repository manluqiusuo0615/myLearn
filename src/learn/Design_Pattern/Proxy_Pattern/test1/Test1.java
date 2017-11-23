package learn.Design_Pattern.Proxy_Pattern.test1;

/**
 * @author 肖长路
 * @Description 测试类
 * @create 2017-09-19 16:26
 */
public class Test1 {
    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.request();
    }
}
