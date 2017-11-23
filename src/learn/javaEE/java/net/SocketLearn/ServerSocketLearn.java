package learn.javaEE.java.net.SocketLearn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 肖长路
 * @Description ServerSocket类实现服务器套接字
 * 服务器套接字等待请求通过网络传入。
 * 它基于该请求执行某些操作，然后可能向请求者返回结果。
 * 服务器套接字的实际工作由 SocketImpl 类的实例执行。
 * 应用程序可以更改创建套接字实现的套接字工厂来配置它自身，
 * 从而创建适合本地防火墙的套接字。
 * @create 2017-09-13 15:16
 */
public class ServerSocketLearn {
    private ServerSocket serverSocket;
    private Socket socket;
    private void ServerSocketConstructor(){
        try {
            //创建非绑定服务器套接字。
            //serverSocket = new ServerSocket();
            //创建绑定到特定端口的服务器套接字
            serverSocket = new ServerSocket(8081);
            //利用指定连接指示（对连接的请求）的最大队列长度创建服务器套接字并将其绑定到指定的本地端口号
            //如果队列满时收到连接指示，则拒绝该连接
            //serverSocket = new ServerSocket(8081,50);
            //使用指定的端口、侦听 backlog 和要绑定到的本地 IP 地址创建服务器。
            //serverSocket = new ServerSocket(int port, int backlog, InetAddress bindAddr)


            serverSocket.setSoTimeout(10000);
            
            //侦听并接受到此套接字的连接。
            //此方法在连接传入之前一直阻塞。
            //****创建新套接字****(注意是创建了一个新的套接字)，
            // 如果存在安全管理器，
            // 则使用 s.getInetAddress().getHostAddress()
            // 和 s.getPort() 作为参数调用安全管理器的 checkAccept 方法，
            // 以确保允许该操作。这可能会导致 SecurityException 异常。
            socket = serverSocket.accept();






            System.out.println("远程主机地址：" + socket.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("谢谢连接我：" + socket.getLocalSocketAddress() + "\nGoodbye!");









            System.out.println(socket.getInetAddress().getHostAddress() + "==========" +socket.getPort());

            //返回此服务器套接字的本地地址  如果套接字是未绑定的，则返回 null
            String address = serverSocket.getInetAddress().toString();
            System.out.println("服务器套接字的本地地址:"+address);
            //返回此套接字在其上侦听的端口
            int port = serverSocket.getLocalPort();
            System.out.println("服务器套接字在其上侦听的端口:"+port);
            //返回此套接字绑定的端点的地址，如果尚未绑定则返回 null
            String lacalAddress = serverSocket.getLocalSocketAddress().toString();
            System.out.println("服务器套接字绑定的端点的地址"+lacalAddress);
            //获取此 ServerSocket 的 SO_RCVBUF 选项的值，
            //该值是将用于从此 ServerSocket 接受的套接字的建议缓冲区大小
            int receiveBufferSize = serverSocket.getReceiveBufferSize();
            System.out.println("ServerSocket 接受的套接字的建议缓冲区大小:"+receiveBufferSize);
            //测试是否启用 SO_REUSEADDR。
            boolean flag = serverSocket.getReuseAddress();
            System.out.println("测试是否启用 SO_REUSEADDR:"+flag);

            




            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        ServerSocketLearn serverSocketLearn = new ServerSocketLearn();
        serverSocketLearn.ServerSocketConstructor();

    }
    
}
