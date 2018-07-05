package annotation20180705;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Ф��·
 * @description
 * @date 2018��07��05�� 14:26
 */
@TestAnnotation(msg="hello")
public class Test2 {
    @Check("hi")
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
        boolean hasAnnotation = Test2.class.isAnnotationPresent(TestAnnotation.class);
        if ( hasAnnotation ) {
            TestAnnotation testAnnotation = Test2.class.getAnnotation(TestAnnotation.class);
            //��ȡ���ע��
            System.out.println("id:"+testAnnotation.id());
            System.out.println("msg:"+testAnnotation.msg());
        }
        try {
            //.getDeclaredField("a");
            Field a = Test2.class.getDeclaredField("a");
            a.setAccessible(true);
            //��ȡһ����Ա�����ϵ�ע��
            if(a!=null){
                Check check = a.getAnnotation(Check.class);
                if ( check != null ) {
                    System.out.println("check value:"+check.value());
                }
            }
            Method testMethod = Test2.class.getDeclaredMethod("testMethod");
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
