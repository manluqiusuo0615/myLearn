通道(Channel)是Java.nio的第二个创新，它们既不是一个扩展也不是
一项增强,而是全新，极好的Java I/O示例.提供与I/O服务的直接连接
Channel用于在字节缓冲区和位于通道另一侧的实体(通常是一个文件或
套接字)之间有效地传输数据
通道是一种途径,借助该途径,可以用最小的总开销来访问操作系统本身
的I/O服务,缓冲区则是通道内部用来发送和接受数据的端点.
与缓冲区不同,通道API主要由接口指定.不同的操作系统上通道实现(
ChannelImplementation)会有根本性的差异.所以通道API仅仅描述
了可以做什么,因此很自然的,通道实现经常使用操作系统的本地代码。
通道接口允许你以一种受控且可移植的方式来访问底层的I/O服务
通道是访问I/O服务的导管,I/O可以分为广义的两个大类别:
File I/O 和 Stream I/O
文件管道  套接字管道
一个FileChannel
三个socket通道类(SocketChannel,ServerSocketChannel,DatagramChannel)
通道会连接一个特定I/O服务，且通道实例(Channel instance)的性能
受它所连接的I/O服务的特征限制
通道可以以阻塞(blocking)或非阻塞(nonblocking)模式运行
非阻塞模式的通道永远不会让调用的线程休眠
请求的操作要么立即完成，要么返回一个结果表明不会让调用的线程休眠
只有面向流(stream-oriented)的通道,如sockets和pipes才能使用非阻塞通道
关闭通道:
通过调用通道的close方法进行关闭,但是可能会导致关闭I/O服务时发生
阻塞(非阻塞模式和阻塞模式都一样)
通过isopen()来测试通道的开发状态,如果返回true,说明通道可以使用
反之,说明通道已关闭,不可使用

