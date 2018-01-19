package learn.collection.Map.test3;

import java.io.*;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月18日 21:11
 */
public class TransDemo {
    public static void main(String[] args) throws IOException {
        Foo foo = new Foo();
        System.out.printf("w: %d%n", Foo.w);
        System.out.printf("x: %d%n", Foo.x);
        System.out.printf("y: %d%n", foo.y);
        System.out.printf("z: %d%n", foo.z);
        try (FileOutputStream fos = new FileOutputStream("x.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(foo);
        }

        foo = null;

        try (FileInputStream fis = new FileInputStream("x.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            System.out.println();
            foo = (Foo) ois.readObject();
            System.out.printf("w: %d%n", Foo.w);
            System.out.printf("x: %d%n", Foo.x);
            System.out.printf("y: %d%n", foo.y);
            System.out.printf("z: %d%n", foo.z);
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe.getMessage());
        }
    }
}
