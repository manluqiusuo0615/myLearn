#什么是IOC/DI？  
IoC 容器：最主要是完成了完成对象的创建和依赖的管理注入等等。  
- 所谓控制反转，就是把原先我们代码里面需要实现的对象创建、依赖的代码，反转给容器来帮忙实现。   
那么必然的我们需要创建一个容器，同时需要一种描述来让容器知道需要创建的对象与对象的关系。  
- 这个描述最具体表现就是我们可配置的文件。  
对象和对象关系怎么表示？  
可以用 xml ， properties 文件等语义化配置文件表示。  
- 描述对象关系的文件存放在哪里？  
可能是 classpath,filesystem,或者是 URL网络资源,servletContext等。  
- 有了配置文件,就需要对配置文件解析,不同的配置文件对对象的描述不一样，如标准的，自定义声明式的，如何统一？   
在内部需要有一个统一的关于对象的定义，所有外部的描述都必须转化成统一的描述定义。  
如何对不同的配置文件进行解析？需要对不同的配置文件语法，采用不同的解析器  
#Spring IOC体系结构？  
