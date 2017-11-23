package learn.javaEE.java.net.test6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 15:37
 */
public class ReadThread implements Runnable {
    private static SocketUtil socketUtil;

    public ReadThread(SocketUtil socketUtil) {
        this.socketUtil = socketUtil;
    }

    @Override
    public void run() {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            socketUtil.write(line);
        }
    }
}
