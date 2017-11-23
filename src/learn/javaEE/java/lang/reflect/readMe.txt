动态获取类的信息以及动态调用对象的方法的功能来自于
Java语言的反射(Reflection)机制
Java反射机制主要提供了一下功能:
在运行时判断任意一个对象所属的类
在运行时构造任意一个类的对象
在运行时判断任意一个类所具有的成员变量和方法
在运行时调用任意一个对象的方法

Reflection是Java被视为动态(或准动态)语言的一个关键
性质.这个机制允许程序在运行时透过Reflection APIs取
得任何一个已知名称的class的内部信息,包括其modifiers
(诸如public,static等等),superclass(例如Object),实
现之interfaces(例如Serializable),也包括fields和methods
的所有信息,并可于运行时改变fields内容或调用methods

一般而言,开发者社区说到动态语言,大致认同的一个定义是:
程序运行时,允许改变程序结构或变量类型,这种语言成为动态语言
从这个观点看:Perl,Python,Ruby是动态语言
C++,Java,C#不是动态语言

尽管在这样的定义与分类下Java不是动态语言,
它却有着一个非常突出的动态相关机制:Reflection
用在Java上指的是我们可以于运行时加载,探知,使用
编译期间完全未知的classes,换句话说,Java程序可以加载
一个运行时才得知名称的class,获悉其完整构造(但不包括
methods定义),并生成其对象实体,或对其fields设值,或唤起其
methods.
这种看透class的能力
(the ability of the program to examine itself)
被称为introspection(内省,内观,反省)
Reflection和introspection是常被并提的两个术语

主要由java.lang.reflect包中的类来实现Java反射机制
Class类:代表一个类(位于java.lang包下)
Field类:代表类的成员变量(成员变量也称为类的属性)
Method类:代表类的构造方法
Constructor类:代表类的构造方法
Array类:提供了动态创建数组,以及访问数组的元素的静态方法

java里面不管某个类有多少对象,这些对象都对应于同
一个Class对象

要想使用反射,首先要获取到目标类所对应的那个class对象
获取某个类或某个对象所对应的Class对象的常用的3种方法:
1.使用Class类的静态方法forName,Class.forName("传入的是类全称");
2.使用类的.class语法:String.class;(类的名称.class)
3.使用对象的getClass()方法

若想通过类的不带参数的构造方法来生成对象,我们有两种方式：
1.先获得Class对象,然后通过该Class对象的newInstance()方法
直接生成即可:
Class<?> classType = String.class;
Object obj = classType.newInstance();
2.先获得Class对象,然后通过该Class对象获得对应的Constructor对象
再通过该Constructor对象的newInstance()方法生成:
Class<?> classType = String.class;
Constructor constructor = classType.getConstructor(new Class[]{});
Object obj = constructor.newInstance(new Object[]{});

若想通过类的带参数的构造方法生成对象,只能使用下面一种方式:
Class<?> classType = String.class;
Constructor constructor = classType.getConstructor(new Class[]{String.class,int.class});
Object obj = constructor.newInstance(new Object[]{"张三",25});

java.lang.Array类提供了动态创建和访问数组元素的各种静态方法.
Integer.TYPE返回的是int
而Integer.class返回的是java.lang.Integer(Integer类所对应的class对象)
注意:int.class返回的是int   =====   Integer.TYPE返回的是int
Boolean也是一样


getDeclaredField
getDeclaredMethod
该对象反映此 Class 对象所表示的类或接口的指定已声明属性或方法(即全部,包括私有)

getField
getMethod
它反映此 Class 对象所表示的类或接口的指定公共成员属性或方法

当用反射操作私有属性或方法的时候,
一定要执行一下父类AccessibleObject的setAccessible()方法
将此对象的accessible标志设置为指示的布尔值。
值为true则指示反射的对象在使用时应该取消Java语言访问检查。
值为false则指示反射的对象应该实施Java语言访问检查

Java有一个Object class,是所有Java classes的继承根源
其内声明了数个应该在所有Java class中被改写的methods:
hashCode(),equals(),clone(),toString(),getClass()等
其中getClass()返回一个Class object

Class class十分特殊.它和一般classes一样继承自Object,其
实体用以表达Java程序运行时的classes和interface,也用来表达enum,
array,primitive Java types(原生的八个类型boolean,byte,char,short,
int,long,float,double)以及关键词void.当一个class被加载(从硬盘加载到JVM中),
或当加载器(class loader)的defineClass()被JVM调用,JVM便自动产生一个Class object
如果你像借由"修改Java标准库源码"来观察Class object的实际生成时机,
不能够,因为Class并没有public constructor
Only the Java Virtual Machine creates Class objects
只有JVM才可以创建Class对象
private Class(ClassLoader loader) {
    classLoader = loader;
}

Class是反射(Reflection)的起源,针对任何你想查看的class,唯有先为它产生一个
class对象,接下来才能由这个对象唤起为数十多个的反射APIs

首先准备一个Class[]作为参数类型,然后以此为自变量调用
getMethod(),获得特定的Method object
接下来准备一个Object[]放置自变量,然后调用特定Method object
的invoke()
Constructor,Field等基本类似,一定要注意这几个自变量

因为method overloading机制要求signature必须唯一,而返回
类型并非signature的一个成分.换句话说,只要指定了method名称
和参数列,就一定指出了一个独一无二的method

修改成员变量直接调用Field object的get("对象名称")和set("对象名称","新值")




















