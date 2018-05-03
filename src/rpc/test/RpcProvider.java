package rpc.test;

import rpc.framework.RpcFramework;

/**
 * @author 肖长路
 * @description
 * @date 2018年05月03日 14:52
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
