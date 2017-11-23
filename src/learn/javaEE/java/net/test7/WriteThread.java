package learn.javaEE.java.net.test7;

import java.io.IOException;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 16:23
 */
public class WriteThread implements Runnable {
    private SocketUtil socketUtil;
    private String message;
    public WriteThread (SocketUtil socketUtil){
        this.socketUtil = socketUtil;
    }
    @Override
    public void run() {
        try {
            socketUtil.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
