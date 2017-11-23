package chatting_software.model;

import java.io.Serializable;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-22 9:21
 */
public class ServerModel implements Serializable{
    private String IP;
    private int port;

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
