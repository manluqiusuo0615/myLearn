package learn.javaEE.java.net.myChar;

import java.io.File;
import java.io.Serializable;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-22 9:07
 */
public class User implements Serializable{
    private String ID;
    private String name;//姓名
    private String nickName;//昵称
    private String sex;
    private int age;

    private File clientLog;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public File getClientLog() {
        return clientLog;
    }

    public void setClientLog(File clientLog) {
        this.clientLog = clientLog;
    }
}
