package rpc.test;

/**
 * @author 肖长路
 * @description
 * @date 2018年05月03日 14:52
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
