Java 中一共有 4 种类型的引用:
StrongReference、 SoftReference、 WeakReference
以及 PhantomReference(传说中的幽灵引用)
这 4 种类型的引用与 GC 有着密切的关系
1. Strong Reference(强引用)
        StrongReference 是 Java 的默认引用实现,
        它会尽可能长时间的存活于 JVM 内，
        当没有任何对象指向它时 GC 执行后将会被回收
2. WeakReference(弱引用)
        当所引用的对象在 JVM 内不再有强引用时,
        GC 后 weak reference 将会被自动回收
3. SoftReference
        SoftReference 于 WeakReference 的特性基本一致,
        最大的区别在于 SoftReference 会尽可能长的保留引用
        直到 JVM 内存不足时才会被回收(虚拟机保证),
        这一特性使得 SoftReference 非常适合缓存应用

在java中，finalize函数本来是设计用来在对象被回收的时候来做一
些操作的（类似C++的析构函数）。但是对象被GC什么时候回收的时间，
却是不固定的，这样finalize函数很尴尬。虚引用(PhantomReference)
可以用来解决这个问题。
在创建虚引用的时候必须传入一个引用队列。在一个对象的finalize函数
被调用之后，这个对象的幽灵引用会被加入到引用队列中。通过检查队列的
内容就知道对象是不是要准备被回收了。
幽灵引用的使用并不多见，主要是实现细粒度的内存控制。比如下面代码实
现一个缓存。程序在确认原来的对象要被回收之后，才申请内存创建新的缓存。


