package learn.javaEE.java.net.test7;

import java.io.IOException;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 16:09
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localHost",9000);
        SocketUtil socketUtil = new SocketUtil(socket);

        Thread t1 = new Thread(new ReadThread(socketUtil));
        Thread t2 = new Thread(new WriteThread(socketUtil));

        t1.start();
        t2.start();

    }
}
