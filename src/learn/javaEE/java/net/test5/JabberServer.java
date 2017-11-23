package learn.javaEE.java.net.test5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 9:38
 */
public class JabberServer {
    public static final int PORT = 8083;

    public static void main(String[] args) throws IOException {

        ServerSocket s = new ServerSocket(PORT);


        System.out.println("服务器等待链接:...");

        Socket socket = s.accept();

        System.out.println("同意的链接为:" + socket);

        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        for (int i = 0; i < 10; i++) {
            pw.println("哈哈!!!链接我干什么???"+i);
        }
        pw.println("END");


        BufferedReader br = null;
        try {
            br = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
            String line ;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }finally {
            br.close();
            pw.close();
        }
    }
}
