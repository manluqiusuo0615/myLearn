（1）经典的TCP通信服务器客户端架构
服务器有一个服务器等待用户连接的线程，该线程循环等待客户端的TCP连接请求。一旦用ServerSocket.accept()捕捉到了连接请求，就为该TCP连接分配一个客户服务线程，通过该消息传递线程服务器与客户端通信。服务器发送消息通过该客户服务线程的方法在主线程完成，而接收消息全部在客户服务线程中循环接收并处理。

客户机能发起一个向服务器的socket连接请求，一旦收到服务器成功响应连接请求客户机便为这个socket分配一个消息接收线程，否则关闭该socket。和服务器任务分配类似，发送消息作为非常用方法在主线程中完成，而接收消息在消息接收线程中不停刷新并作相应处理。
（2）统一ASCII码级文本传输协议

为了实现客户机对服务器命令的响应、服务器对客户机需求的解读以及客户机与客户机之间的消息传递，我为服务器和客户端之间通信定义了一组文本传输协议。协议属于变长文本传输协议，用@作为各字段分隔符，所有消息的首节一定是消息类型，方便解析。协议定义了以下按发送方分类的消息格式
（3）MVC分层模式

Model-View-Controller是经典的应用程序开发设计模式，它讲数据管理、界面显示和用户交互、程序维护管理分别封装在MVC三种类中，够成松耦合关系。本次实验中我也利用MVC的设计思路，独立了Model类User用于保存客户机用户信息，DefaultListModel模型类用于储存在线用户队列；而View并没有单独放在一个类中，而是在Controller类Server和Client中以Java Swing的控件形式独立开来。Controller监听用户操作事件，反映给Model类处理并在View中更新。

MVC的思想即是M和V之间不要直接产生联系，业务逻辑均封装在MC中，而V仅仅负责显示。本实验为V类绑定了各自的Listener监听用户操作，在C中完成业务逻辑处理，保存并更新User和DefaultListModel，最后再显示到UI界面上。

（4）concurrentHashMap管理线程队列和用户列表

concurrentHashMap是java.util.concurrent包中定义的多线程安全的哈希表，利用哈希表管理线程队列和用户列表可以快速索引，多线程安全也保证了多个用户服务线程之间共享资源的数据一致性。
