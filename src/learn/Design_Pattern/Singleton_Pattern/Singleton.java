package learn.Design_Pattern.Singleton_Pattern;

/**
 * @author 肖长路
 * @Description 单例模式顾名思义
 * 就是实例只有一个
 * 要实现这种效果就不能使用平常的new方式在内存中创建实例
 * 不能使用new,就说明构造要私有
 * 构造私有后,外界要获取对象就只能使用类静态方法获取实例
 * @create 2017-09-15 16:49
 */
public class Singleton {
    private static Singleton singleton;
    //非原子性操作
    private static volatile Singleton singleton2;
    //在类初始化就创建实例
    public static final Singleton SINGLETON = new Singleton();

    private Singleton() {
    }

    /**
     * 懒汉式,线程安全
     * 这个判断遇到了多线程就会出现不安全想象
     * 所以要加机制锁(但是它并不高效)
     * 因为在任何时候只能有一个线程调用singletonFactory()方法
     * 然而同步操作只需要在第一次调用时才被需要,后续只是使用的第一次
     * 生成的实例对象而已  这就引出了双重检验锁
     *
     * @return
     */
    public static synchronized Singleton singletonFactory() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    //instance = new Singleton()这句,这并非是一个原子操作
                    //事实上在 JVM 中这句话大概做了下面3件事情
                    //1.给singleton分配内存
                    //2.调用Singleton的构造函数来初始化成员变量
                    //3.将singleton对象指向分配的内存空间(执行完这步singleton就为非null了)
                    //但是在 JVM 的即时编译器中存在指令重排序的优化
                    //也就是说上面的第二步和第三步的顺序是不能保证的
                    //最终的执行顺序可能是 1-2-3 也可能是 1-3-2
                    //如果是后者,则在3执行完毕,2未执行之前,被线程二抢占了,
                    //这时singleton已经是非null了(但却没有初始化),
                    //所以线程二会直接返回singleton使用,然后顺理成章地报错
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 有些人认为使用 volatile 的原因是可见性，也就是可以保证线程
     * 在本地不会存有 instance 的副本，每次都是去主内存中读取。
     * 但其实是不对的。使用 volatile 的
     * 主要原因是其另一个特性：禁止指令重排序优化。
     * 也就是说，在 volatile 变量的赋值操作后面
     * 会有一个内存屏障（生成的汇编代码上），读操作不会被重排序到内存屏障之前
     * 取操作必须在执行完 1-2-3 之后或者 1-3-2 之后，不存在执行到 1-3 然后取到值的情况
     * 从「先行发生原则」的角度理解的话，就是
     * 对于一个 volatile 变量的写操作都先行发生于后面对这个变量的读操作
     * （这里的“后面”是时间上的先后顺序）
     *
     * @return
     */
    public static Singleton getSingleton1() {
        if (singleton2 == null) {
            synchronized (Singleton.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton();
                }
            }
        }
        return singleton2;
    }

    /**
     * 饿汉式 static final field
     * 缺点是它不是一种懒加载模式（lazy initialization），
     * 单例会在加载类后一开始就被初始化，即使客户端没有调用 singletonFactory1()方法
     * 饿汉式的创建方式在一些场景中将无法使用：
     * 譬如 Singleton 实例的创建是依赖参数或者配置文件的，
     * 在 singletonFactory1() 之前必须调用某个方法设置参数给它，
     * 那样这种单例写法就无法使用了
     *
     * @return
     */
    public static Singleton singletonFactory1() {
        return SINGLETON;
    }

    /**
     * 静态内部类 static nested class
     * 这种写法仍然使用JVM本身机制保证了线程安全问题
     * 由于 SingletonHolder 是私有的
     * 除了 singletonFactory2() 之外没有办法访问它
     * 因此它是懒汉式的
     * 同时读取实例的时候不会进行同步,没有性能缺陷,也不依赖 JDK 版本
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static final Singleton singletonFactory2() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 首先，枚举类似类，一个枚举可以拥有成员变量，成员方法，构造方法
     * 创建enum时，编译器会自动为我们生成一个继承自java.lang.Enum的类
     * 创建枚举默认就是线程安全的
     * 所以不需要担心double checked locking
     * 而且还能防止反序列化导致重新创建新的对象
     */
    public enum SomeThing {
        INSTANCE;
        private Singleton instance;

        SomeThing() {
            instance = new Singleton();
        }

        public Singleton getInstance() {
            return instance;
        }
    }

}
