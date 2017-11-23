package learn.javaEE.java.net.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-21 15:08
 */
public class Server {
    public static void main(String[] args) {
        Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                socket = serverSocket.accept();

                StringBuffer stringBuffer = new StringBuffer();
                InputStream is = socket.getInputStream();

                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = is.read(buffer, 0, buffer.length)) != -1) {
                    String str = new String(buffer);
                    stringBuffer.append(str);
                    if (str.indexOf("==!!") != -1) {
                        break;
                    }
                }
                System.out.println("客户端说:" + stringBuffer);

                OutputStream os = socket.getOutputStream();
                String message = "asdfasdfasdf大撒旦发顺丰";
                message = MessageUtile.addEnd(message);
                os.write(message.getBytes());
                os.flush();

                is.close();
                os.close();
                socket.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
