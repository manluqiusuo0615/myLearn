通过泛型,将获得编译时类型的安全和
运行时更小的抛出ClassCastExceptions(类型转换异常)的可能

所谓泛型:就是变量类型的参数化

在定义泛型类型时,预设可以使用任何的类型来实例化泛型类型,
但是如果想要限制使用泛型类别时,只能用某个特定类型或者是
其子类型才能实例化该类型时,可以在定义类型时,使用extends
关键字指定这个类型必须是继承某个类,或者实现某个接口
注意:不管后面跟着是接口还是类,都是用extends关键字来执行
public class ListGenericFoo<T extends List<Integer>>
上面的T表示这个T要是List<Integer>继承体系下的类

当我们没有指定泛型继承的类型或接口时,默认使用T extends Object
所以默认情况下任何类型都可以作为参数传入

实例化类型持有者时,它必须是实现List的类别或其子类别,
要定义这样一个名称,你可以使用'?'通配字元,并使用"extends"
关键字限定类型持有者的形态
Generic2<? extends List<String>> ge = null;
ge = new Generic2<ArrayList<String>>();
ge = new Generic2<LinkedList<String>>();

向上泛型
Generic2<? super List<String>> generic2 = null;
generic2 = new Generic2<Collection<String>>();
generic2 = new Generic2<Object>();

Generic2<? extends Object> g4 = new Generic2();
也可以写成
Generic2<?> g4 = new Generic2();
//在编译的时候,知道g4是一个Object类型,但不知道是不是一个字符串
g4.setFooArray(null);(正确)
g4.setFooArray("1111111");(错误)
使用<?>或是<? extends SomeClass>的声明方式,意味着你只能
通过该名称来取得(读取)所参考实例的信息,或者是移除(就是删除,赋值为null)某些信息
,但不能增加(修改)
它的信息,因为只知道当中防止的是SomeClass的子类,但不确定是什么类
的实例,编译器不让你加入信息,
理由:如果可以加入信息的话,那么你就得记住取回的实例是什么类型,
然后转换为原来的类型方可进行操作,这就失去了使用类型的意义

