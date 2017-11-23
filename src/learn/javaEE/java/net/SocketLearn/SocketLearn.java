package learn.javaEE.java.net.SocketLearn;

import java.io.*;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-13 15:15
 */
public class SocketLearn {

    private Socket socket;

    private void socketLearnConstructor() {
        try {
            socket = new Socket("localhost", 8081);


            System.out.println("远程主机地址：" + socket.getRemoteSocketAddress());
            OutputStream outToServer = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + socket.getLocalSocketAddress());
            InputStream inFromServer = socket.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketLearn socketLearn = new SocketLearn();
        socketLearn.socketLearnConstructor();
    }
}
