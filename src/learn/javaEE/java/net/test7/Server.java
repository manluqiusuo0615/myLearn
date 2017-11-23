package learn.javaEE.java.net.test7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 16:09
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        System.out.println("socket:"+socket);
        SocketUtil socketUtil = new SocketUtil(socket);

        Thread t1 = new Thread(new ReadThread(socketUtil));
        Thread t2 = new Thread(new WriteThread(socketUtil));

        t2.start();
        t1.start();
    }
}
