package learn.javaEE.java.net.test6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 15:02
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localHost",9000);



        SocketUtil socketUtil = new SocketUtil(socket);

        Thread t1 = new Thread(new WriteThread(socketUtil));
        t1.start();

        Thread t2 = new Thread(new ReadThread(socketUtil));
        t2.start();
            
    }
}
