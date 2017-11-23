ArithmeticException当出现异常的运算条件时，抛出此异常
例如,一个整数"除以零"时,抛出此类的一个实例
java中的异常分为两大类:
a)Checked exception(非运行时异常)
b)Unchecked exception(Runtime Exception运行时异常)

异常可以处理,错误无法处理

Throwable类是Java语言中所有错误或异常的超类.只有当对象是
此类(或其子类之一)的实例时,才能通过Java虚拟机或者Java throw
语句抛出.类似地,只有此类或其子类之一才可以是catch 子句中
的参数类型,两个子类的实例,Error和Exception,通常用于指示
发生了异常情况

Java中所有的异常类都会直接或间接的继承Exception
Exception类及其子类是Throwable的一种形式,它指出了合理的
应用程序想要捕获的条件

RuntimeException是那些可能在Java虚拟机正常运行期间
抛出的异常的超类,可能在执行方法期间抛出但未被捕获的
RuntimeException的任何子类都无需在throws子句中进行声明
RuntimeException类也是直接继承自Exception类,它叫做运行
时异常,Java中所有的运行时异常都会直接或间接的继承
自RuntimeException

Java中凡是继承自Exception而不是继承自RuntimeException的
类都是非运行时异常

对于非运行时异常,必须要对其进行处理,处理方式有两种:
1)try{..}catch(Exception e){..}finally{...}
2)在调用该会产生异常的方法所在的方法声明中throws Exception,
让上层进行异常处理,如果main中进行了异常抛出,就是将异常交与
JVM进行处理

对于运行时异常,我们可以不对其进行处理,也可以对其进行处理

我们可以使用多个catch块来捕获异常,这时需要将父类型的catch
块放到子类型的catch块之后,这样才能保证后续的catch可能被执
行,否则子类型的catch将永远无法到达,Java编译器会报编译错误.
如果多个catch块的异常类型是独立(没有继承关系)的,那么谁前谁
后都是可以的.

如果try块中存在return语句,那么首先也需要将finally块中的代
码执行完毕,然后方法再返回
System.exit(0)====表示虚拟机直接正常运行停止,会终止当前运
行的Java虚拟机
如果try块中存在System.exit(0),那么久不会执行finally块中
代码

NullPointerException空指针异常,出现该异常的原因在于
某个引用为null,但你却调用了它的某个方法,这时候就会出现该
异常

所谓自定义异常,通常就是定义了一个继承自Exception类的子类,
那么这个类就是一个自定义的异常类.通常我们都会直接继承自
Exception类,一般不会继承某个运行时的异常类

java.sql.SQLException:无法从套接字读取更多的数据
出现的原因是:之前与数据库建立的连接套接字因为数据库的重启
而失效了,还有一个原因就是网络连接不正常.
引起这种错误的原因很多,几点建议:
1、检查程序,优化数据库操作及SQL语句,如该关闭的数据库链接要及时关闭、查询语句该简化的简化;
2、检查网络状况,排除网络原因;
3、调整数据库配置参数,比如:会话超时时间、每秒最大连接数、最大连接数等等;
4、看看数据库的版本,有没有升级的可能,也许会解决这个问题;











