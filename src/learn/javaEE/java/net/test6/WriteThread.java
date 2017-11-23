package learn.javaEE.java.net.test6;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 15:40
 */
public class WriteThread implements Runnable {
    private static SocketUtil socketUtil;

    public WriteThread(SocketUtil socketUtil) {
        this.socketUtil = socketUtil;
    }

    @Override
    public void run() {
        while (true) {
            String getMessage = socketUtil.read();
            System.out.println(getMessage);
        }

    }
}
