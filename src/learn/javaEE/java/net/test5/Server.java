package learn.javaEE.java.net.test5;

import java.io.*;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 14:27
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9000);

        BufferedWriter bufferedWriter =
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
        for(int i=0;i<10;i++){
            bufferedWriter.write("客户端说:......"+i);
            bufferedWriter.newLine();
        }
        bufferedWriter.write("END");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
        String line = null;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
