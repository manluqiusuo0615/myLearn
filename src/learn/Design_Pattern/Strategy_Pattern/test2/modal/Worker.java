package learn.Design_Pattern.Strategy_Pattern.test2.modal;

/**
 * @author 肖长路
 * @description
 * @date 2017年12月13日 20:29
 */
public class Worker {
    int id;
    String name;
    int age;

    public Worker(){}

    public Worker(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
