package annotation20180705.test2;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * @author Ф��·
 * @description  Base base = AnnotationUtils.findAnnotation(methd, Base.class);
 * ��ֱ�ӻ��ע���ע��(����ע��!)��û�з���null
 * @date 2018��07��09�� 11:19
 */
public class TwoAnno {
    /**������ʹ�õ��Ǹ���ע��*/
    @Two
    private String getAll(){
        return "ok";
    }

    /**�����ϵ�ע��*/
    @Target({ElementType.TYPE,ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Base{
        public String value() default "";
    }

    /**����ע��**/
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Base("haha")
    @interface Two{

    }

    /**
     * ����ע��Ľ���
     */
    public void test2() throws NoSuchMethodException, SecurityException{
        Class<TwoAnno> x = TwoAnno.class;
        Method methd = x.getDeclaredMethod("getAll", new Class[]{});
        /**������ע��*/
        Annotation[] anns = methd.getDeclaredAnnotations();
        Annotation a = null;
        for (Annotation ann : anns) {
            if (ann.annotationType() == Base.class) {
                System.out.println("11111111");
                a = ann;
            }
        }
        if(a==null){
            /**��ʾֻ��2��ģ������Ҫ�ݹ鴦��*/
            for (Annotation ann : anns) {
                if (!(ann.annotationType()!= null&& ann.annotationType().getName().startsWith("java.lang.annotation"))) {
                    Class<? extends Annotation> annParent = ann.annotationType();
                    Annotation[]  anns2 = annParent.getDeclaredAnnotations();
                    for (Annotation ann2 : anns2) {
                        if (ann2.annotationType() == Base.class) {
                            System.out.println("2222222222");
                            a = ann2;
                        }
                    }
                }
            }
        }
        if(a==null){
            System.out.println("û�ҵ�ע��");
        }else{
            Base res = (Base)a;
            System.out.println(res.value());
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        TwoAnno twoAnno = new TwoAnno();
        twoAnno.test2();
    }
}
