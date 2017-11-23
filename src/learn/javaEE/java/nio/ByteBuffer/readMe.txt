在Java中当我们要对数据进行更底层的操作时，一般是操作数据的字节（byte）形式;
Java的内存使用机制,使得ByteBuffer有两种静态实例方法：
allocate(int capacity) 和 allocateDirect(int capacity)
第一种分配方式产生的内存开销是在JVM中的
而另外一种的分配方式产生的开销在JVM之外，也就是系统级的内存分配
当Java程序接收到外部传来的数据时，首先是被系统内存所获取，
然后在由系统内存复制到JVM内存中供Java程序使用
所以,allocateDirect比allocate省去了复制这个步骤
但是系统级内存的分配比起JVM内存的分配要耗时得多
当操作数据量非常小时，两种分配方式操作使用时间基本是同样的，
allocate有时可能会更快，可是当数据量非常大时，
allocateDirect会远远大于第一种的分配方式

速度的提高来自于所使用的结构更接近于操作系统执行I/O的方式：通道和缓冲器
java.nio.ByteBuffer字节缓冲区(它是一个相当基础的类)
通过告知分配多少存储空间[allocate(int capacity)]来创建一个ByteBuffer对象,
并且还有一个方法选择集,用于以原始的字节形式或基本数据类型输出和读取数据.
但是没有办法输出和读取对象,即使是字符串对象也不行.
这种处理虽然低级,但却非常好,因为这是大多数操作系统中更有效的映射方式.

缓冲区:特定基本类型元素的线性有限序列.除内容外,缓冲区的基本属性还包括容量,限制和位置
读写数据时候,本质就是从此缓冲区的"位置"处一直读到"限制"处.



旧I/O类库中有三个类被修改了,用以产生FileChannel.这三个被修改的类是
FileInputStream FileOutputStream以及读写共存的RandomAccessFile
注意,这些是字节操纵流,与底层nio性质一致.
Reader和Writer这种字符模式类不能用于产生通道（Channels类提供了实用方法,用以
在通道中产生Reader和Writer)
FileInputStream.getChannel()所返回通道的初始position将等于到目前为止
从文件中读取的字节数.从此流中读取的字节会使通道的位置递增.
通过读取来更改通道的位置间接的更改此流的文件位置
FileOutputStream.getChannel()所返回通道的初始java.nio.channels.FileChannel#position()position
将等于到目前为止从文件中读取的字节数,
除非此流处于挂起模式,在这种情况下,它将等于文件的大小.
将字节写入此流中会使通道的位置相应地增加.
显式地或通过写入来更改通道的位置会更改此流的文件位置
RandomAccessFile.getChannel()返回通道的
java.nio.channels.FileChannel#position()position
将始终等于 getFilePointer 方法返回的此对象的文件指针偏移量.
显式或者通过读取或写入字节来更改此对象的文件指针偏移量将更改通道的位置,
反之亦然.通过此对象更改此文件的长度将更改通过文件通道看到的长度,反之亦然.


通道是一种相当基础的东西,可以向它传送用于读写的ByteBuffer,并且可以锁定文件的某些
区域用于独占式访问.
将字节存放于ByteBuffer的方法：
一是put,填入一个字节或多个字节,或基本数据类型值
二是使用warp()将已存在的字节数组"包装"到ByteBuffer中
一旦如此,就不再复制底层的数组,而是将这个数组作为一个ByteBuffer对象,
这里称为数组支持的ByteBuffer
nio的目标就是快速移动大量数据,所以BytyBuffer的大小就显得尤为重要
三是通过通道的read方法,从通道中读取数据向缓冲区放置

nio中的读和写都是相对通道来说的,向通道写数据和从通道读数据
一旦调用read()来告知ByteBuffer接收从FileChannel读取的字节,就必须调用缓冲器上的flip()
让缓冲器做好让别人(FileChannel)读取字节的准备
flip()将limit属性设置为当前的位置,初始位置为0
而rewind()是在limit属性已经被设置合适的情况下使用的
两个方法虽然都能够使指针返回到缓冲区的第一个位置
但是flip()在调整指针之前,将limit属性设置为当前位置
而rewind()方法,limit属性为设置好的值

如果我们打算使用缓冲器执行进一步的read()操作,我们也必须得调用clear()来为每一个read()
做好准备,clear()操作会对所有的内部指针重新安排,以便缓冲期在另外一个操作期间能做好准备

特殊方法transferTo()和transferFrom()允许我们将一个通道和另一个通道直接相连

CharBuffer中toString()方法:返回一个包含缓冲器中所有字符的字符串
ByteBuffer可以看作是具有asCharBuffer()方法的CharBuffer

缓冲期容纳的是普通的字节,为了把他们转为字符,要么在输入他们的时候对其进行编码(这样他们输出才具有意义)
要么在将其从缓冲器输出时对他们进行解码



