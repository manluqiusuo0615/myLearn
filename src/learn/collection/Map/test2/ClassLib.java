package learn.collection.Map.test2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月18日 21:07
 */
public class ClassLib implements Serializable {
    private transient InputStream is;

    private int majorVer;
    private int minorVer;

    ClassLib(InputStream is) throws IOException {
        System.out.println("ClassLib(InputStream) called");
        this.is = is;
        DataInputStream dis;
        if(is instanceof DataInputStream){
            dis = (DataInputStream) is;
        }else{
            dis = new DataInputStream(is);
        }
        if(dis.readInt() != 0xcafebabe){
            throw new IOException("not a .class file");
        }
        minorVer = dis.readShort();
        majorVer = dis.readShort();
    }

    int getMajorVer() {
        return majorVer;
    }

    int getMinorVer() {
        return minorVer;
    }

    void showIS() {
        System.out.println(is);
    }
}
