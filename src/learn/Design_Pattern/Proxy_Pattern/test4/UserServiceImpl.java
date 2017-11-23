package learn.Design_Pattern.Proxy_Pattern.test4;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 11:09
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("真实对象要执行的方法...");
    }
}
