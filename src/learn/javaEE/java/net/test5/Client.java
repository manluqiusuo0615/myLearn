package learn.javaEE.java.net.test5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 14:27
 */
public class Client {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
        String line = null;
        StringBuffer stringBuffer = new StringBuffer();
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
            stringBuffer.append(line+"\n");
            if(line.equals("END")){
                break;
            }
        }

        BufferedWriter bufferedWriter =
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
        bufferedWriter.write(stringBuffer.toString());

        bufferedWriter.close();
        bufferedReader.close();

    }
}
