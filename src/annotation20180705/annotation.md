#ע��  
- Annotation �������������ע�⡢���͵���˼  
ע����ͬ��ǩ,��ǩ�Ƕ�������Ϊ��ĳЩ�Ƕȵ����������   
�����������,ע����Ƕ��ڴ�����ĳЩ�ʻ��������ȥ��һ�ű�ǩ��������,ע����ͬһ�ű�ǩ��   
Annotation(ע��)��JDK1.5���Ժ�汾����ġ����������ڴ����ĵ������ٴ����е������ԣ�����ִ�л�������ʱ��顣  
ͬclasss��interfaceһ��,ע��Ҳ����һ�����͡�  
- ע������'@ע����'�ڴ����д��ڵģ�����ע������ĸ��������ǿ��Խ�ע���Ϊ�����ע�⡢��ֵע�⡢����ע�����ࡣ  
���Ƕ�����ֱ��Ӱ�쵽��������壬ֻ����Ϊע�⣨��ʶ�����ڣ����ǿ���ͨ��������Ʊ��ʵ�ֶ���ЩԪ���ݣ������������ݵ����ݣ��ķ��ʡ�  
���⣬������ڱ���ʱѡ��������ע���Ƿ�ֻ������Դ���뼶��������Ҳ����class�ļ�����������ʱ�г��֣�SOURCE/CLASS/RUNTIME����  
ע����൱��һ�����Դ������Ҫ���õ�һ���࣬Ҫ��Դ������Ӧ��ĳ��ע�⣬����׼���������ע���࣬������Ҫ����ĳ���࣬����Ҫ����������ࡣ 
## Ԫ���ݵ�����
���Ҫ����Ԫ���ݵ����ý��з��࣬��û����ȷ�Ķ��壬�������ǿ��Ը�������������ã����¿ɷ�Ϊ���ࣺ  
>1.��д�ĵ���ͨ���������ʶ��Ԫ���������ĵ���  
>2.���������ͨ���������ʶ��Ԫ���ݶԴ�����з�����  
>3.�����飺ͨ���������ʶ��Ԫ�����ñ�������ʵ�ֻ����ı�����  
## ע��Ķ���
ע��ͨ�� @interface �ؼ��ֽ��ж��塣  
```
public @interface TestAnnotation {

}
``` 
������ʽ���ӿں����ƣ�����ǰ�����һ�� @ ���š�����Ĵ���ʹ�����һ������Ϊ TestAnnotaion ��ע�⡣   
�Լ����Ϊ������һ������Ϊ TestAnnotation �ı�ǩ��   
## ע���Ӧ��
������һ��ע�⣬��ôע��ĵ�ʹ�÷�����ʲô�ء�  
```
@TestAnnotation
public class Test {
}
```
����һ���� Test,Ȼ�����ඨ��ĵط����� @TestAnnotation �Ϳ����� TestAnnotation ע��������ˡ�   
���Լ����Ϊ�� TestAnnotation ���ű�ǩ���� Test ��������档    
## Ԫע��
Ԫע����ʲô��˼�أ�   
Ԫע���ǿ���ע�⵽ע���ϵ�ע�⣬����˵Ԫע����һ�ֻ���ע�⣬�������ܹ�Ӧ�õ�������ע�����档   
Ԫע��Ҳ��һ�ű�ǩ����������һ������ı�ǩ���������ú�Ŀ�ľ��Ǹ�������ͨ�ı�ǩ���н���˵���ġ�   
Ԫ��ǩ�� @Retention��@Documented��@Target��@Inherited��@Repeatable 5 �֡�   
### @Retention
Retention ��Ӣ����Ϊ�����ڵ���˼    
�� @Retention Ӧ�õ�һ��ע���ϵ�ʱ��������˵�������ע��ĵĴ��ʱ�䡣    
����ȡֵ���£�
- RetentionPolicy.SOURCE ע��ֻ��Դ��׶α������ڱ��������б���ʱ�������������ӡ�   
- RetentionPolicy.CLASS ע��ֻ��������������е�ʱ���������ᱻ���ص� JVM �С�   
- RetentionPolicy.RUNTIME ע����Ա������������е�ʱ�����ᱻ���ؽ��뵽 JVM �У������ڳ�������ʱ���Ի�ȡ�����ǡ�   
@Retention ȥ��һ�ű�ǩ���͵�ʱ����ָ�������ű�ǩ������ʱ�䡣  
@Retention �൱�ڸ�һ�ű�ǩ�������һ��ʱ�����ʱ���ָ���˱�ǩ������ʱ�����ڡ�   
```
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
}
```
ָ�� TestAnnotation �����ڳ����������ڱ���ȡ������������������ڷǳ��ĳ���
### @Documented
����˼�壬���Ԫע��϶��Ǻ��ĵ��йء������������ܹ���ע���е�Ԫ�ذ����� Javadoc ��ȥ��
### @Target
Target ��Ŀ�����˼��@Target ָ����ע�����õĵط���   
��һ��ע�ⱻ @Target ע��ʱ�����ע��ͱ��޶������õĳ�����    
��ȵ���ǩ��ԭ����ǩ�������������ĸ��ط��͵��ĸ��ط���������Ϊ @Target �Ĵ��ڣ��������ĵط��ͷǳ������ˣ�   
����ֻ�������������ϡ����ϡ����������ϵȵȡ�@Target �������ȡֵ    
- ElementType.ANNOTATION_TYPE ���Ը�һ��ע�����ע��
- ElementType.CONSTRUCTOR ���Ը����췽������ע��
- ElementType.FIELD ���Ը����Խ���ע��
- ElementType.LOCAL_VARIABLE ���Ը��ֲ���������ע��
- ElementType.METHOD ���Ը���������ע��
- ElementType.PACKAGE ���Ը�һ��������ע��
- ElementType.PARAMETER ���Ը�һ�������ڵĲ�������ע��
- ElementType.TYPE ���Ը�һ�����ͽ���ע�⣬�����ࡢ�ӿڡ�ö��
### @Inherited
Inherited �Ǽ̳е���˼��������������˵ע�Ȿ����Լ̳У�����˵���һ�����౻ @Inherited ע�����ע��   
����ע��Ļ�����ô�����������û�б��κ�ע��Ӧ�õĻ�����ô�������ͼ̳��˳����ע�⡣   
```
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Test {}
//һ��Testע�ⱻ  @Inherited  @Retention  ע����

@Test
public class A {}

public class B extends A {}
```
ע�� Test �� @Inherited ���Σ�֮���� A �� Test ע�⣬�� B �̳� A,�� B Ҳӵ�� Test ���ע�⡣  
����:
���ӷǳ���Ǯ���������Ǹ�������һ�ű�ǩ����������   
���ӵĶ��ӳ����ֻҪû�к����ӶϾ����ӹ�ϵ����Ȼ����û�и�������ǩ����������ȻҲ�Ǹ�����   
���ӵ����ӳ����ˣ���ȻҲ�Ǹ�����   
��������ǿ���Ϸ�Ƶĸ�һ����������������������Ȼ�з���ͬ������ö����ǩ������ʵ����ı���Ҳ����������һ�Ź�ͬ�ı�ǩ��Ҳ�����������ϵ����Ÿ����ı�ǩ��   
### @Repeatable
Repeatable ��Ȼ�ǿ��ظ�����˼��@Repeatable �� Java 1.8 �żӽ����ģ���������һ���µ����ԡ�   
ʲô����ע�����Ӧ���أ�ͨ����ע���ֵ����ͬʱȡ�����      
һ���������ǳ���Ա���ǲ�Ʒ����,ͬʱ�����Ǹ����ҡ�   
```
//����ע��
@interface Persons {
    Person[]  value();
}

@Repeatable(Persons.class)
@interface Person{
    String role default "";
}

@Person(role="artist")
@Person(role="coder")
@Person(role="PM")
public class SuperMan{

}
```
@Repeatable ע���� Person  
�� @Repeatable ���������е����൱��һ������ע�⡣   
ʲô������ע���أ����������������ע��ĵط���������Ҳ��һ��ע�⡣   
���չ涨�����������Ҫ��һ�� value �����ԣ�����������һ���� @Repeatable ע�����ע�����飬ע���������顣  
����������Ļ�������������⡣Persons ��һ���ܵı�ǩ������������ Person ����ͬ���͵����ݲ�һ���ı�ǩ��   
�� Persons ��һ�� SuperMan ���ϣ��൱��ͬʱ�������˳���Ա����Ʒ�������ҵı�ǩ��    
���� @Person(role=��PM��) �������������   
��ʵ���Ǹ� Person ���ע��� role ���Ը�ֵΪ PM    
## ע�������
ע�������Ҳ������Ա������ע��ֻ�г�Ա������û�з�����  
ע��ĳ�Ա������ע��Ķ������ԡ����βεķ�������ʽ��������  
�䷽���������˸ó�Ա���������֣��䷵��ֵ�����˸ó�Ա���������͡� 
```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    int id();
    String msg();
}
``` 
������붨���� TestAnnotation ���ע����ӵ�� id �� msg �������ԡ���ʹ�õ�ʱ������Ӧ�ø����ǽ��и�ֵ��   
��ֵ�ķ�ʽ����ע����������� value=���� ��ʽ���������֮ǰ�� ��������     
```
@TestAnnotation(id=3,msg="hello annotation20180705")
public class Test {

}
```
��Ҫע����ǣ���ע���ж�������ʱ�������ͱ����� 8 �ֻ�������������� �ࡢ�ӿڡ�ע�⼰���ǵ����顣  
ע�������Կ�����Ĭ��ֵ��Ĭ��ֵ��Ҫ�� default �ؼ�ֵָ����  
```$xslt
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    public int id() default -1;
    public String msg() default "Hi";
}
```
TestAnnotation �� id ����Ĭ��ֵΪ -1��msg ����Ĭ��ֵΪ Hi��  
����������Ӧ�á�  
```$xslt
@TestAnnotation()
public class Test {}
```
��Ϊ��Ĭ��ֵ����������Ҫ���� @TestAnnotation ���������������и�ֵ�ˣ���һ������ʡ�ԡ�   
���⣬����һ����������һ��ע���ڽ���ֻ��һ������Ϊ value ������ʱ��Ӧ�����ע��ʱ����ֱ�ӽ�����ֵ��д�������ڡ�  
```$xslt
public @interface Check {
    String value();
}
```
��������У�Check ���ע��ֻ�� value ������ԡ����Կ�������Ӧ�á�
```$xslt
@Check("hi")
int a;
```
��������Ч����һ����
```$xslt
@Check(value="hi")
int a;
```
��󣬻���Ҫע���һ�������һ��ע��û���κ����ԡ�����
```$xslt
public @interface Perform {}
```
��ô��Ӧ�����ע���ʱ�����Ŷ�����ʡ�ԡ�
```$xslt
@Perform
public void testMethod(){}
```
## Java Ԥ�õ�ע��
Java ���Ա����Ѿ��ṩ�˼����ֳɵ�ע�⡣  
### @Deprecated
���Ԫ����������ǹ�ʱ��Ԫ�أ���ش�����ճ������о����������������ڱ���׶��������ע��ʱ�ᷢ�����Ѿ��棬   
���߿��������ڵ���һ����ʱ��Ԫ�ر����ʱ�ķ�������ʱ���ࡢ��ʱ�ĳ�Ա������ 
```$xslt
public class Hero {
    @Deprecated
    public void say(){
        System.out.println("Noting has to say!");
    }

    public void speak(){
        System.out.println("I have a dream!");
    }
}
```
������һ�� Hero �࣬������������ say() �� speak() ������ say() �� @Deprecated ע�⡣Ȼ�������� IDE �зֱ�������ǡ�   
```$xslt
Hero hero = new Hero();
//say()�����ϻ�����һ������
hero.say();
hero.speak();
```
���Կ�����say() �������汻һ��ֱ�߻���һ��������ʵ���Ǳ�����ʶ��������Ч����   
### @Override
��ʾ����Ҫ��д�����б� @Override ���εķ���   
### @SuppressWarnings 
��ֹ�������˼��֮ǰ˵�����ñ� @Deprecated ע��ķ����󣬱������ᾯ�����ѣ�   
����ʱ�򿪷��߻�������־��棬���ǿ����ڵ��õĵط�ͨ�� @SuppressWarnings �ﵽĿ�ġ�   
```$xslt
@SuppressWarnings("deprecation")
public void test1(){
    Hero hero = new Hero();
    hero.say();
    hero.speak();
}
```
### @SafeVarargs
������ȫ����ע�⡣����Ŀ�������ѿ����߲�Ҫ�ò�����һЩ����ȫ�Ĳ���,   
���Ĵ��ڻ���ֹ���������� unchecked �����ľ��档������ Java 1.7 �İ汾�м���ġ�   
```$xslt
@SafeVarargs // Not actually safe!
static void m(List<String>... stringLists) {
    Object[] array = stringLists;
    List<Integer> tmpList = Arrays.asList(42);
    array[0] = tmpList; // Semantically invalid, but compiles without warnings
    String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
}
```
����Ĵ����У�����׶β��ᱨ����������ʱ���׳� ClassCastException ����쳣����������Ȼ���߿�����Ҫ���ƴ������ǿ������Լ����Ǹ����ˡ�   
Java �ٷ��ĵ�˵��δ���İ汾����Ȩ�����������ֲ���ȫ�Ĳ����������󾯸档
### @FunctionalInterface
����ʽ�ӿ�ע�⣬����� Java 1.8 �汾����������ԡ�����ʽ��̺ܻ����� Java 8 Ҳ��ʱ�����������ԡ�   
����ʽ�ӿ� (Functional Interface) ����һ������һ����������ͨ�ӿڡ�   
```$xslt
@FunctionalInterface
public interface Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see     java.lang.Thread#run()
     */
    public abstract void run();
}
```
���ǽ����߳̿����г��õ� Runnable ����һ�����͵ĺ���ʽ�ӿڣ�����Դ����Կ������ͱ� @FunctionalInterface ע�⡣    
����ʽ�ӿڱ����ʲô�ã����ԭ���Ǻ���ʽ�ӿڿ��Ժ�����ת��Ϊ Lambda ���ʽ��   
## ע�����ȡ
�ñ�ǩ������ע�⣬ǰ��������ǽ���ôдע�⣬Ȼ�������ĸ��ط�ȥ��������Ҫ���Ĺ������Ǽ�����Щ��ǩ���ݡ�  
����ı������������Щע���ǩ�ں��ʵ�ʱ��˺������Ȼ����������������Ϣ��  
Ҫ����ȷ����ע�⣬�벻��һ���ֶΣ��Ǿ��Ƿ��䡣   
### ע���뷴��
ע��ͨ�������ȡ�����ȿ���ͨ�� Class ����� isAnnotationPresent() �����ж����Ƿ�Ӧ����ĳ��ע��   
```$xslt
public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {}
```
Ȼ��ͨ�� getAnnotation() ��������ȡ Annotation ����
```$xslt
public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {}
```
������ getAnnotations() ������
```$xslt
public Annotation[] getAnnotations() {}
```
ǰһ�ַ�������ָ�����͵�ע�⣬��һ�ַ�������ע�⵽���Ԫ���ϵ�����ע�⡣   
�����ȡ���� Annotation �����Ϊ null����Ϳ��Ե������ǵ����Է����ˡ�����   
```$xslt
@TestAnnotation()
public class Test {
    public static void main(String[] args) {
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        if ( hasAnnotation ) {
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            System.out.println("id:"+testAnnotation.id());
            System.out.println("msg:"+testAnnotation.msg());
        }
    }
}
```
��������н���ǣ�
```$xslt
id:-1
msg:
```
������� TestAnnotation �� id �� msg ��Ĭ��ֵ��  
����������У�ֻ�Ǽ��ĳ���ע�������ϵ�ע�⣬��ʵ���ԡ������ϵ�ע�������ǿ��Եġ�ͬ������Ҫ�����ڷ��䡣  
```$xslt
@TestAnnotation(msg="hello")
public class Test {
    @Check(value="hi")
    int a;
    @Perform
    public void testMethod(){}
    @SuppressWarnings("deprecation")
    public void test1(){
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }
    public static void main(String[] args) {
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        if ( hasAnnotation ) {
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            //��ȡ���ע��
            System.out.println("id:"+testAnnotation.id());
            System.out.println("msg:"+testAnnotation.msg());
        }
        try {
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);
            //��ȡһ����Ա�����ϵ�ע��
            Check check = a.getAnnotation(Check.class);
            if ( check != null ) {
                System.out.println("check value:"+check.value());
            }
            Method testMethod = Test.class.getDeclaredMethod("testMethod");
            if ( testMethod != null ) {
                // ��ȡ�����е�ע��
                Annotation[] ans = testMethod.getAnnotations();
                for( int i = 0;i < ans.length;i++) {
                    System.out.println("method testMethod annotation20180705:"+ans[i].annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
```
���ǵĽ�����£�
```$xslt
id:-1
msg:hello
check value:hi
method testMethod annotation20180705:Perform
```
��Ҫע����ǣ����һ��ע��Ҫ������ʱ���ɹ���ȡ����ô @Retention(RetentionPolicy.RUNTIME) �Ǳ���ġ�  
���ĳ��ע��û��@Retention(RetentionPolicy.RUNTIME)  ���޷���ȡ���ġ�
���磺check����û��@Retention(RetentionPolicy.RUNTIME)����ô���޷���ȡ  check value:hi
## ע���ʹ�ó���
ע�⵽����ʲô�ã�  
Java �ٷ��ĵ�:  
&nbsp;&nbsp;&nbsp;&nbsp;ע����һϵ��Ԫ���ݣ����ṩ�����������ͳ�����룬����ע�Ⲣ���������͵Ĵ��뱾���һ���֡�ע����ڴ��������Ч��û��ֱ��Ӱ�졣  
&nbsp;&nbsp;&nbsp;&nbsp;ע��������ô�����Ҫ���£�  
- �ṩ��Ϣ���������� ��������������ע����̽�����;�����Ϣ  
- ����׶�ʱ�Ĵ��� ������߿�����������ע����Ϣ�����ɴ��롢Html�ĵ�������������Ӧ����  
- ����ʱ�Ĵ��� ĳЩע������ڳ������е�ʱ����ܴ������ȡ  
**ֵ��ע����ǣ�ע�ⲻ�Ǵ��뱾���һ���֡�**   
���������⣬�����������������ƻ��������ƣ�������ΪĳЩ�˶�������ɵx�������۶��ı䣬��ǩֻ��ĳЩ�˶���������������ۣ�  
���Ǳ�ǩ����ı����ﱾ����ǩֻ���ض���Ⱥ���ֶΡ����ԣ�ע��ͬ���޷��ı���뱾��ע��ֻ��ĳЩ���ߵĵĹ��ߡ�  
**���ǻص��ٷ��ĵ��Ľ����ϣ�ע����Ҫ��Ե��Ǳ������������������(SoftWare tool)��**
��������ʹ����Annotation �������ࡢ������Field �ȳ�Ա֮����Щ Annotation �����Լ���Ч��  
�����ɿ������ṩ��Ӧ�Ĵ�������ȡ������ Annotation ��Ϣ��  
��Щ������ȡ�ʹ��� Annotation �Ĵ���ͳ��Ϊ APT��Annotation Processing Tool)��   
**ע����ʲô�ã���˭�ã���  ������ ���� APT �õġ�**
## �����Զ���ע�����ĳ��Ŀ��
```
public class NoBug {
    @Jiecha
    public void suanShu(){
        System.out.println("1234567890");
    }
    @Jiecha
    public void jiafa(){
        System.out.println("1+1="+1+1);
    }
    @Jiecha
    public void jiefa(){
        System.out.println("1-1="+(1-1));
    }
    @Jiecha
    public void chengfa(){
        System.out.println("3 x 5="+ 3*5);
    }
    @Jiecha
    public void chufa(){
        System.out.println("6 / 0="+ 6 / 0);
    }
    public void ziwojieshao(){
        System.out.println("��д�ĳ���û�� bug!");
    }
}
```
����Ĵ��룬��Щ�������������� @Jiecha ע�⡣
```$xslt
@Retention(RetentionPolicy.RUNTIME)
public @interface Jiecha {
}
```
��дһ�������� TestTool �Ϳ��Բ��� NoBug ��Ӧ�ķ����ˡ�
```$xslt
public class TestTool {
    public static void main(String[] args) {
        NoBug testobj = new NoBug();

        Class clazz = testobj.getClass();

        Method[] method = clazz.getDeclaredMethods();
        //������¼���Բ����� log ��Ϣ
        StringBuilder log = new StringBuilder();
        // ��¼�쳣�Ĵ���
        int errornum = 0;

        for ( Method m: method ) {
            // ֻ�б� @Jiecha ��ע���ķ����Ž��в���
            if ( m.isAnnotationPresent( Jiecha.class )) {
                try {
                    m.setAccessible(true);
                    m.invoke(testobj, null);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    //e.printStackTrace();
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //��¼���Թ����У��������쳣������
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //��¼���Թ����У��������쳣�ľ�����Ϣ
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }

        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errornum);
        log.append(" error.");

        // ���ɲ��Ա���
        System.out.println(log.toString());

    }
}
```
���ԵĽ���ǣ�
```$xslt
1-1=0
3 x 5=15
1+1=11
1234567890
chufa has error:
  caused by ArithmeticException
/ by zero
NoBug has  1 error.
```
��ʾ NoBug ���е� chufa() ����������쳣������쳣���ƽ��� ArithmeticException��ԭ������������н����˳� 0 �Ĳ�����  
���ԣ�NoBug ������� Bug��   
������ͨ��ע��������Լ���Ŀ�ģ��Ǿ��ǶԱ��˵Ĵ�����в��ԡ�  
����ע��ʲôʱ���ã���ȡ����������������ʲô�á�  
## �ܽ�
- ���ע��������⣬��Ͱ�����ͬ�ڱ�ǩ����ǩΪ�˽������ע��Ϊ�˽��ʹ��롣
- ע��Ļ����﷨��������ͬ�ӿڣ����Ƕ��˸� @ ���š�
- ע���Ԫע�⡣
- ע������ԡ�
- ע����Ҫ�����������������͵�����õġ�
- ע�����ȡ��Ҫ������ Java �ķ��似��������Ƚ���������ע��ʹ��ʱҲ��Ҫ�����ƽ�ʱ��ɱ���






















