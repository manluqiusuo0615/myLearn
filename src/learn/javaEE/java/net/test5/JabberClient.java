package learn.javaEE.java.net.test5;

import java.io.*;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 10:08
 */
public class JabberClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8083);

        System.out.println("socket = " + socket);

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = null;

        br = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            stringBuilder.append(line + "\n");
            System.out.println(line);
            if(line.equals("END")){
                break;
            }
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(socket.getOutputStream());
            pw.println("客户端说:"+stringBuilder);
        } finally {
            if (pw != null) {
                pw.close();
                br.close();
            }
        }
    }
}
