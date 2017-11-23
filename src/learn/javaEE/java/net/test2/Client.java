package learn.javaEE.java.net.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-21 15:08
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);


            OutputStream os = socket.getOutputStream();
            String message = "65465465465456";
            message = MessageUtile.addEnd(message);
            os.write(message.getBytes());
            os.flush();

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
            System.out.println("服务器说:" + stringBuffer);



            is.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
