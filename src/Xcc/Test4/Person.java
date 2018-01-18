package Xcc.Test4;

import java.util.Random;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月18日 17:37
 */
public class Person {
    private String id;
    private String name;
    private String age;

    Person(){
        setName(getName());
        setAge(getAge());
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        String base = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<3;i++){
            int index = new Random().nextInt(base.length());
            stringBuffer.append(base.charAt(index));
        }
        String name = stringBuffer.toString();
        return name.replaceFirst(name.substring(0, 1),name.substring(0, 1).toUpperCase());
    }

    public String getAge() {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<2;i++){
            int index = new Random().nextInt(10);
            stringBuffer.append(index);
        }
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID号='" + id + '\'' +
                ", 姓名='" + name + '\'' +
                ", 年龄='" + age + '\'' +
                '}';
    }
}
