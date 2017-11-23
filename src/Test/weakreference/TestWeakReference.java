package Test.weakreference;

import java.lang.ref.WeakReference;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 15:25
 */
public class TestWeakReference {
    public static void main(String[] args) {
        Car car = new Car(22000, "silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);

        int i = 0;

        while (true) {
            if (weakCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                //程序打印出"Object has been collected."
                //说明, weak reference指向的对象的被回收了
                System.out.println("Object has been collected.");
                break;
            }
        }
    }
}
