package learn.javaEE.java.net.test6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 15:03
 */
public class SocketUtil {
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    public SocketUtil(Socket socket) {
        this.socket = socket;
        try {
            this.bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
            this.printWriter =
                    new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从socket中获取读到的内容
     *
     * @return
     */
    public String read() {
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\n");
                if(line.equals("\n")){
                    break ;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /**
     * 想socket中写入数据
     *
     * @param message
     */
    public void write(String message) {
        printWriter.println(message);
    }

    public void close() {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (printWriter != null) {
            printWriter.close();
        }
    }

}
