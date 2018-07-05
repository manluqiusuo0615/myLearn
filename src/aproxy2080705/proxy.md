# ����
������Ӣ�� Proxy ��������ġ������������м������Ĵ����������ľ�������Ȧ������Ĥ��ͬѧ�ˡ�  
���Ǵӳ����û���Ȼ��������Ȧ��������Ȼ���������ˡ�  
����˵���˿Ϳ���ֱ�Ӵӳ��ҹ����Ʒ��������ʵ�����У�����������������ģʽ��  
һ�㶼�ǳ���ί�и������̽������ۣ��˿͸������̴򽻵�������ֱ�����Ʒʵ�������߽��й�����   
���ԣ��������һ���м��˵�ζ����  
������������˵˵����еĴ���ģʽ��  
# ����ģʽ
����ģʽ������������бȽϳ��������ģʽ��  
```$xslt
Client ----->   �ܹ�������Ľӿ�(Subject)<<interface>>
                                    |
                                    |
                                    |
                                    |
                                    |
                                    |
                                    |
                    -----------------------------------
                    |                                  |
                    |                                  |
                ����(Proxy)                  ����������Ķ���(RealSubject)
```
��Ҫע��������漸�㣺 
1. �û�ֻ���Ľӿڹ��ܣ������ں�˭�ṩ�˹��ܡ���ͼ�нӿ��� Subject��
2. �ӿ�����ʵ��������ͼ�� RealSubject�������������û�ֱ�ӽӴ�������ͨ������
3. ���������ͼ�е� Proxy��������ʵ���� Subject �ӿڣ��������ܹ�ֱ�����û��Ӵ���
4. �û����� Proxy ��ʱ��Proxy �ڲ������� RealSubject�����ԣ�Proxy ���н��ߣ���������ǿ RealSubject ������    
������Է�Ϊ��̬����Ͷ�̬��������
# ��̬����
����ƽ��ȥ��ӰԺ����Ӱ��ʱ���ڵ�Ӱ��ʼ�Ľ׶��ǲ��Ǿ�����Ź���أ�  
��Ӱ�ǵ�Ӱ��˾ί�и�ӰԺ���в��ŵģ�����ӰԺ�����ڲ��ŵ�Ӱ��ʱ�򣬲���һЩ�Լ��ľ������棬
���������׻������ֵȣ�Ȼ����ӰƬ��ʼ����ʱ����һЩ��档   
�����ô���������ģ�⡣  
���ȵ���һ���ӿڣ�ͨ�õĽӿ��Ǵ���ģʽʵ�ֵĻ���������ӿ���������Ϊ Movie�������Ӱ���ŵ�������  
```$xslt
public interface Movie {
    void play();
}
```
Ȼ������Ҫ��һ��������ʵ����� Movie �ӿڵ��࣬��һ��ֻ��ʵ�ֽӿڵĴ����ࡣ
```$xslt
public class RealMovie implements Movie{
    @Override
    public void play() {
        System.out.println("�����ڹۿ���Ӱ ��Ф��˵ľ��꡷");
    }
}
```
�����ʾ������ӰƬ����ʵ���� Movie �ӿڣ�play() ��������ʱ��ӰƬ�Ϳ�ʼ���š���ô Proxy �����أ�
```$xslt
public class Cinema implements Movie{
    RealMovie movie;
    public Cinema(RealMovie movie) {
        super();
        this.movie = movie;
    }
    public void guanggao(boolean isStart){
        if ( isStart ) {
            System.out.println("��Ӱ���Ͽ�ʼ�ˣ����׻������֡�������9.8�ۣ������򰡣�");
        } else {
            System.out.println("��Ӱ���Ͻ����ˣ����׻������֡�������9.8�ۣ���ؼҳ԰ɣ�");
        }
    }
    @Override
    public void play() {
        guanggao(true);

        movie.play();

        guanggao(false);
    }
}
```
Cinema ���� Proxy �����������һ�� play() �������������� play() ����ʱ����������һЩ�������Ĵ����Ǿ��ǹ�档  
���Դ�������:
```$xslt
public class ProxyTest {
    public static void main(String[] args) {
        RealMovie realmovie = new RealMovie();

        Movie movie = new Cinema(realmovie);

        movie.play();
    }
}
```
���Խ��:
```$xslt
��Ӱ���Ͽ�ʼ�ˣ����׻������֡�������9.8�ۣ������򰡣�
�����ڹۿ���Ӱ ��Ф��˵ľ��꡷
��Ӱ���Ͻ����ˣ����׻������֡�������9.8�ۣ���ؼҳ԰ɣ�
```
���ڿ��Կ�����
**����ģʽ�����ڲ��޸ı��������Ļ����ϣ�ͨ����չ�����࣬����һЩ���ܵĸ�������ǿ��
ֵ��ע����ǣ�������ͱ�������Ӧ�ù�ͬʵ��һ���ӿڣ������ǹ�ͬ�̳�ĳ���ࡣ**  
������ܵ��Ǿ�̬��������ݣ�Ϊʲô������̬�أ���Ϊ��������������Ԥ���õģ�������������е� Cinema ����ࡣ
# ��̬����
��Ȼ�Ǵ�����ô���뾲̬����Ĺ�����Ŀ����û������ģ�Ψһ������ľ��Ƕ�̬�뾲̬�Ĳ��    
��ô�ڶ�̬�����������̬������ʲô�ط���   
��������� Cinema ���Ǵ���������Ҫ�ֶ���д������ Cinema ʵ�� Movie �ӿڣ�
���ڶ�̬�����У����ǿ���**�ó��������е�ʱ���Զ����ڴ��д���һ��ʵ��** Movie **�ӿڵĴ���**��
**������Ҫȥ����** Cinema ���**������**�������������Ϊ��̬��ԭ��   
������һ�����̳����̳��кܶ�Ĺ�̨����һ����̨��ę́�ơ�
```$xslt
public interface SellWine {
    void mainJiu();
}
```
SellWine ��һ���ӿڣ�����������Ϊ���Ƶ����֤��
```
public class MaotaiJiu implements SellWine {
    @Override
    public void mainJiu() {
        System.out.println("��������ę́�ơ�");
    }
}
```
Ȼ�󴴽�һ���� MaotaiJiu,�Եģ�����ę́�Ƶ���˼��
```$xslt
public class GuitaiA implements InvocationHandler {
    private Object pingpai;
    public GuitaiA(Object pingpai) {
        this.pingpai = pingpai;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("���ۿ�ʼ  ��̨�ǣ� "+this.getClass().getSimpleName());
        method.invoke(pingpai, args);
        System.out.println("���۽���");
        return null;
    }
}
```
Ȼ�����ǾͿ��������ˡ�
```$xslt
public class Test {
    public static void main(String[] args) {
        MaotaiJiu maotaijiu = new MaotaiJiu();

        InvocationHandler jingxiao1 = new GuitaiA(maotaijiu);

        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(
                MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(),
                jingxiao1
        );

        dynamicProxy.mainJiu();

    }
}
```
���
```$xslt
���ۿ�ʼ  ��̨�ǣ� GuitaiA
��������ę́�ơ�
���۽���
```
����û�У���û����̬��������Ϊ SellWine �ӿ�ʵ��һ������Ĵ����࣬����������Ȼʵ������ͬ�Ĺ��ܣ�
�����еĲ�𣬾���֮ǰ���۵Ķ�̬������ν����̬����ԭ�� 
# ��̬�����﷨
��̬�����漰��һ���ǳ���Ҫ���� Proxy������ͨ�� Proxy �ľ�̬���� newProxyInstance �Żᶯ̬��������
## Proxy
```$xslt
public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
```
���潲������ 3 ���������塣
- loader ��Ȼ���������
- interfaces ����Ҫ��������Ľӿ�
- h һ�� InvocationHandler ����
## InvocationHandler
InvocationHandler ��һ���ӿڣ��ٷ��ĵ�����˵��ÿ�������ʵ������һ����֮������ InvocationHandler ʵ���࣬
�������ķ��������ã���ô������֪ͨ��ת�����ڲ��� InvocationHandler ʵ���࣬������������
```$xslt
public interface InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
```
InvocationHandler �ڲ�ֻ��һ�� invoke() �������������������������ô����������ݹ����ķ������á�
- proxy �������
- method ���������õķ���
- args ���õķ����еĲ���
��Ϊ��Proxy ��̬�����Ĵ������� InvocationHandler ʵ���࣬���� InvocationHandler ��ʵ��ִ���ߡ�
GuitaiA ����ʵ�������Ƶĵط���  
���ڣ����ǼӴ��Ѷȣ����ǲ���Ҫ��ę́�ƣ�����������Һ��  
```$xslt
public class Wuliangye implements SellWine{
    @Override
    public void mainJiu() {
        System.out.println("������������Һ��");
    }
}
```
Wuliangye �����Ҳʵ���� SellWine ����ӿڣ�˵����Ҳӵ�����Ƶ����֤��ͬ�������ŵ� GuitaiA ��������
```$xslt
public class Test {
    public static void main(String[] args) {
        MaotaiJiu maotaijiu = new MaotaiJiu();
        Wuliangye wuliangye = new Wuliangye();

        InvocationHandler jingxiao1 = new GuitaiA(maotaijiu);
        InvocationHandler jingxiao2 = new GuitaiA(wuliangye);

        SellWine dynamicProxy1 = (SellWine) Proxy.newProxyInstance(
                MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(),
                jingxiao1
        );
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(
                MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(),
                jingxiao2
        );

        dynamicProxy1.mainJiu();
        dynamicProxy2.mainJiu();

    }
}
```
�������������
```$xslt
���ۿ�ʼ  ��̨�ǣ� GuitaiA
��������ę́�ơ�
���۽���
���ۿ�ʼ  ��̨�ǣ� GuitaiA
������������Һ��
���۽���
```
���˻��ʣ�dynamicProxy1 �� dynamicProxy2 ʲô����û�У����Ƕ��Ƕ�̬�����Ĵ��������ۻ�Ա����ӵ�����Ƶļ���֤�顣  
�����������̳��ľ�Ӫ����������֮�⣬��Ҫ���̡�  
���ȣ�ͬ��Ҫ����һ���ӿڣ���Ϊ���̵����֤��  
```$xslt
public interface SellCigarette {
    void sell();
}
```
Ȼ����ʲô���أ����Ǻ����ˣ��Ǿ�ܽ�������ˡ�
```$xslt
public class Furongwang implements SellCigarette{
    @Override
    public void sell() {
        System.out.println("�����������ڵ�ܽ����������ɨ���������֤��");
    }
}
```
Ȼ���ٴβ�����֤��
```$xslt
public class Test {
    public static void main(String[] args) {
        MaotaiJiu maotaijiu = new MaotaiJiu();
        Wuliangye wuliangye = new Wuliangye();

        Furongwang fu = new Furongwang();

        InvocationHandler jingxiao1 = new GuitaiA(maotaijiu);
        InvocationHandler jingxiao2 = new GuitaiA(wuliangye);

        InvocationHandler jingxiao3 = new GuitaiA(fu);

        SellWine dynamicProxy1 = (SellWine) Proxy.newProxyInstance(
                MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(),
                jingxiao1
        );
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(
                MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(),
                jingxiao2
        );

        dynamicProxy1.mainJiu();
        dynamicProxy2.mainJiu();

        SellCigarette dynamicProxy3 = (SellCigarette) Proxy.newProxyInstance(Furongwang.class.getClassLoader(),
                Furongwang.class.getInterfaces(), jingxiao3);

        dynamicProxy3.sell();

    }
}
```
�鿴�����
```$xslt
���ۿ�ʼ  ��̨�ǣ� GuitaiA
��������ę́�ơ�
���۽���
���ۿ�ʼ  ��̨�ǣ� GuitaiA
������������Һ��
���۽���
���ۿ�ʼ  ��̨�ǣ� GuitaiA
�����������ڵ�ܽ����������ɨ���������֤��
���۽���
```
ͬ����ͨ�� Proxy.newProxyInstance() ������ȴ������ SellWine �� SellCigarette ���ֽӿڵ�ʵ�����������Ƕ�̬�����ħ���� 
# ��̬���������
����Ϊʲô Proxy �ܹ���̬������ͬ�ӿ����͵Ĵ������Ȥ���ҵĲ²��ǿ϶�ͨ�������ȥ�Ľӿ�Ȼ��ͨ�����䶯̬������һ���ӿ�ʵ����  
���� SellWine ��һ���ӿڣ���ô Proxy.newProxyInstance() �ڲ��϶�����
```$xslt
new SellWine();
```
������ͬ���õĴ��룬��������ͨ��������ƴ����ġ���ô��ʵ�ǲ����������أ�ֱ�Ӳ鿴���ǵ�Դ����ˡ���Ҫ˵�����ǣ��ҵ�ǰ�鿴��Դ���� 1.8 �汾��
```$xslt
@CallerSensitive
    public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h) throws IllegalArgumentException{
        Objects.requireNonNull(h);

        final Class<?>[] intfs = interfaces.clone();
        final SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            checkProxyAccess(Reflection.getCallerClass(), loader, intfs);
        }

        Class<?> cl = getProxyClass0(loader, intfs);

        try {
            if (sm != null) {
                checkNewProxyPermission(Reflection.getCallerClass(), cl);
            }

            final Constructor<?> cons = cl.getConstructor(constructorParams);
            final InvocationHandler ih = h;
            if (!Modifier.isPublic(cl.getModifiers())) {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {
                    public Void run() {
                        cons.setAccessible(true);
                        return null;
                    }
                });
            }
            return cons.newInstance(new Object[]{h});
        } catch (IllegalAccessException|InstantiationException e) {
            throw new InternalError(e.toString(), e);
        } catch (InvocationTargetException e) {
            Throwable t = e.getCause();
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new InternalError(t.toString(), t);
            }
        } catch (NoSuchMethodException e) {
            throw new InternalError(e.toString(), e);
        }
    }
```
newProxyInstance ��ȷ������һ��ʵ��������ͨ�� cl ��� Class �ļ��Ĺ��췽���������ɡ�cl �� getProxyClass0() ������ȡ�� 
```$xslt
private static Class<?> getProxyClass0(ClassLoader loader,Class<?>... interfaces) {
        if (interfaces.length > 65535) {
            throw new IllegalArgumentException("interface limit exceeded");
        }

        // If the proxy class defined by the given loader implementing
        // the given interfaces exists, this will simply return the cached copy;
        // otherwise, it will create the proxy class via the ProxyClassFactory
        return proxyClassCache.get(loader, interfaces);
    }
```
ֱ��ͨ�������ȡ�������ȡ������ע��˵��ͨ�� ProxyClassFactory��һ���ڲ��ࣩ ���ɡ� 
```$xslt
private static final class ProxyClassFactory implements BiFunction<ClassLoader, Class<?>[], Class<?>>{
        // prefix for all proxy class names    Proxy class ��ǰ׺�� ��$Proxy��
        private static final String proxyClassNamePrefix = "$Proxy";

        // next number to use for generation of unique proxy class names
        private static final AtomicLong nextUniqueNumber = new AtomicLong();

        @Override
        public Class<?> apply(ClassLoader loader, Class<?>[] interfaces) {

            Map<Class<?>, Boolean> interfaceSet = new IdentityHashMap<>(interfaces.length);
            for (Class<?> intf : interfaces) {
                /*
                 * Verify that the class loader resolves the name of this
                 * interface to the same Class object.
                 */
                Class<?> interfaceClass = null;
                try {
                    interfaceClass = Class.forName(intf.getName(), false, loader);
                } catch (ClassNotFoundException e) {
                }
                if (interfaceClass != intf) {
                    throw new IllegalArgumentException(
                        intf + " is not visible from class loader");
                }
                /*
                 * Verify that the Class object actually represents an
                 * interface.
                 */
                if (!interfaceClass.isInterface()) {
                    throw new IllegalArgumentException(
                        interfaceClass.getName() + " is not an interface");
                }
                /*
                 * Verify that this interface is not a duplicate.
                 */
                if (interfaceSet.put(interfaceClass, Boolean.TRUE) != null) {
                    throw new IllegalArgumentException(
                        "repeated interface: " + interfaceClass.getName());
                }
            }

            String proxyPkg = null;     // package to define proxy class in
            int accessFlags = Modifier.PUBLIC | Modifier.FINAL;

            /*
             * Record the package of a non-public proxy interface so that the
             * proxy class will be defined in the same package.  Verify that
             * all non-public proxy interfaces are in the same package.
             */
            for (Class<?> intf : interfaces) {
                int flags = intf.getModifiers();
                if (!Modifier.isPublic(flags)) {
                    accessFlags = Modifier.FINAL;
                    String name = intf.getName();
                    int n = name.lastIndexOf('.');
                    String pkg = ((n == -1) ? "" : name.substring(0, n + 1));
                    if (proxyPkg == null) {
                        proxyPkg = pkg;
                    } else if (!pkg.equals(proxyPkg)) {
                        throw new IllegalArgumentException(
                            "non-public interfaces from different packages");
                    }
                }
            }

            if (proxyPkg == null) {
                // if no non-public proxy interfaces, use com.sun.proxy package
                proxyPkg = ReflectUtil.PROXY_PACKAGE + ".";
            }

            /*
             * Choose a name for the proxy class to generate.
             */
            long num = nextUniqueNumber.getAndIncrement();
            String proxyName = proxyPkg + proxyClassNamePrefix + num;

            /*
             * Generate the specified proxy class.
             */
            byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                proxyName, interfaces, accessFlags);
            try {
                return defineClass0(loader, proxyName,
                                    proxyClassFile, 0, proxyClassFile.length);
            } catch (ClassFormatError e) {
                /*
                 * A ClassFormatError here means that (barring bugs in the
                 * proxy class generation code) there was some other
                 * invalid aspect of the arguments supplied to the proxy
                 * class creation (such as virtual machine limitations
                 * exceeded).
                 */
                throw new IllegalArgumentException(e.toString());
            }
        }
    }
```
������ע��˵��ͨ��ָ���� ClassLoader �� �ӿ����� �ù����������� proxy class�� Ȼ����� proxy class �������ǣ�
```$xslt
// Proxy class ��ǰ׺�� ��$Proxy����
private static final String proxyClassNamePrefix = "$Proxy";
long num = nextUniqueNumber.getAndIncrement();
String proxyName = proxyPkg + proxyClassNamePrefix + num;
```
���ԣ���̬���ɵĴ�����������**����+$Proxy+id���**��
��ʵԴ���ڲ����ǽ�����һ�ѵĴ�����жϣ�Ȼ��ƴ�ӳ�һ����ɵĴ���������  ����+����
����ȡ�������.class�ļ���Ȼ��class�ļ�������ײ��C�����˴�����������
���ɵĹ��̣����Ĵ������£�
```$xslt
//��ȡ�������.class�ļ�
byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName, interfaces, accessFlags);

return defineClass0(loader, proxyName,proxyClassFile, 0, proxyClassFile.length);
```
defineClass0() ��һ�� native ����
�������ǻ���Ҫ��һЩ��֤����Ҫ���һ�¶�̬���ɵĴ�����������ǲ��ǰ���+$Proxy+id��š�   
```$xslt
System.out.println("dynamicProxy1 class name:"+dynamicProxy1.getClass().getName());
System.out.println("dynamicProxy2 class name:"+dynamicProxy2.getClass().getName());
System.out.println("dynamicProxy3 class name:"+dynamicProxy3.getClass().getName());
```
�����
```$xslt
dynamicProxy1 class name:com.sun.proxy.$Proxy0
dynamicProxy2 class name:com.sun.proxy.$Proxy0
dynamicProxy3 class name:com.sun.proxy.$Proxy1
```
SellWine �ӿڵĴ��������ǣ�com.sun.proxy.$Proxy0
SellCigarette �ӿڵĴ��������ǣ�com.sun.proxy.$Proxy1
��˵����̬���ɵ� proxy class �� Proxy �����ͬһ������
$Proxy0 ����ͨ�� Proxy ��̬���ɵġ�
$Proxy0 ʵ����Ҫ����Ľӿڡ�
$Proxy0 ͨ������ InvocationHandler ��ִ������
# �ܽ�
- �����Ϊ��̬����Ͷ�̬�������֡�
- ��̬������������Ҫ�Լ���д����д�ɡ�
- ��̬����������ͨ�� Proxy.newInstance() �������ɡ�
- �����Ǿ�̬�����Ƕ�̬���������뱻�����߶�Ҫʵ�������ӿڣ����ǵ�ʵ��������ӿڱ�̡�
- ��̬����Ͷ�̬���������������Ҫ��Ҫ�������Լ����� Proxy �ࡣ
- ��̬����ͨ�� Proxy ��̬���� proxy class��������Ҳָ����һ�� InvocationHandler ��ʵ���ࡣ
- ����ģʽ�����ϵ�Ŀ����Ϊ����ǿ���д���Ĺ��ܡ�







