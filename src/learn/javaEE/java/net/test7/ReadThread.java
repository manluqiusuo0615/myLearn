package learn.javaEE.java.net.test7;

import java.io.IOException;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 16:09
 */
public class ReadThread implements Runnable {
    private SocketUtil socketUtil;
    public ReadThread (SocketUtil socketUtil){
        this.socketUtil = socketUtil;
    }

    @Override
    public void run() {
        try {
            System.out.println(socketUtil.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
