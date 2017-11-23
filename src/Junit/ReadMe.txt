a).首先获得待测试类所对应的Class对象
b).然后通过该Class对象获得当前类中所有
public方法所对应的Method数组
c).遍历该Method数组,取得每一个Method对象
d).调用每个Method对象的isAnnotationPresent(Test.class)
方法,判断该方法是否被Test注解所修饰
e).如果该方法返回true,那么调用method.invoke()
方法去执行该方法,否则不执行
