package learn.javaEE.java.net.test7;

import java.io.*;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 16:11
 */
public class SocketUtil {
    private Socket socket;
    private BufferedReader bufferedReader;
    public PrintWriter printWriter;
//    private BufferedWriter bufferedWriter;

    public SocketUtil(Socket socket) {
        this.socket = socket;
        try {
            this.bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
            this.printWriter =
                    new PrintWriter(socket.getOutputStream(), true);
//            this.bufferedWriter =
//                    new BufferedWriter(
//                            new OutputStreamWriter(
//                                    socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read() throws IOException {
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            sb.append(line+"\n");
            if (line.equals("\n")) {
                break;
            }
        }
        return sb.toString();
    }

    public void write() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line!=null){
            printWriter.println(line);
        }
//        String line = br.readLine();
//        if(line.equals("\n")){
//            br.close();
//        }
//        printWriter.println(line);
//        bufferedWriter.write(br.readLine()+"\n");
//        bufferedWriter.newLine();
//        bufferedWriter.flush();
    }
}
