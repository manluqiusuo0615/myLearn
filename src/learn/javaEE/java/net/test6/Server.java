package learn.javaEE.java.net.test6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 15:02
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
//        List<Socket> list = new ArrayList<Socket>();
        Socket socket;
        SocketUtil socketUtil;
        while (true) {
            socket = serverSocket.accept();
//            list.add(socket);
            socketUtil = new SocketUtil(socket);

            Thread t1 = new Thread(new WriteThread(socketUtil));
            t1.start();

            Thread t2 = new Thread(new ReadThread(socketUtil));
            t2.start();
        }
    }
}
