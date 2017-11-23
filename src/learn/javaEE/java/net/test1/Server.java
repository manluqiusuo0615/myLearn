package learn.javaEE.java.net.test1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-21 14:09
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int length = 0;
            String message;
            while ((inputStream.read(buffer, 0, buffer.length)) != -1) {
                message = new String(buffer);
                if (message.indexOf("ok") != -1) {
                    System.out.println("====" + message);
                    break;
                }
            }

            outputStream.write("11111111111111".getBytes());
            outputStream.write("ok".getBytes());
            outputStream.flush();//写完后要记得flush


            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            ServerSocket server = new ServerSocket(9999);
//            //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
//            Socket socket = server.accept();
//            //跟客户端建立好连接之后，我们就可以获取socket的InputStream，并从中读取客户端发过来的信息了。
//            Reader reader = new InputStreamReader(socket.getInputStream());
//            char chars[] = new char[64];
//            int len;
//            StringBuilder sb = new StringBuilder();
//            while ((len = reader.read(chars)) != -1) {
//                sb.append(new String(chars, 0, len));
//            }
//            System.out.println("from client: " + sb);
//            reader.close();
//            socket.close();
//            server.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
