要使用静态成员(方法和变量)我们必须给出
提供这个静态成员的类,
使用静态导入可以使被导入类的
所有静态变量和静态方法
在当前类直接可见
使用这些静态成员无需再给出他们的类名

静态导入：import static ****.静态成员变量名称/静态成员方法名称
例如：
import static learn.array.Commo.AGE;//表示导入Common类中的静态成员变量AGE
import static learn.array.Commo.outPut;//表示导入Common类中的静态方法outPut()
注意：使用import static 时,要一直导入到类中的静态成员变量或静态方法这个级别

