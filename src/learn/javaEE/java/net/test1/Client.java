package learn.javaEE.java.net.test1;

import java.io.*;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-21 14:28
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",9999);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            
            outputStream.write("222222222222222".getBytes());
            outputStream.write("ok".getBytes());
            outputStream.flush();//写完后要记得flush

            byte[] buffer = new byte[1024];
            int length = 0;
            String message ;
            while((inputStream.read(buffer,0,buffer.length))!=-1){
                message = new String(buffer);
                if(message.indexOf("ok")!=-1){
                    System.out.println("===="+message);
                    break ;
                }
            }



            inputStream.close();
            outputStream.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            Socket client = new Socket("localhost", 9999);
//            //建立连接后就可以往服务端写数据了
//            Writer writer = new OutputStreamWriter(client.getOutputStream());
//            writer.write("Hello Server.");
//            writer.flush();//写完后要记得flush
//            writer.close();
//            client.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
