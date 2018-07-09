package annotation20180705.test2;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * @author 肖长路
 * @description  Base base = AnnotationUtils.findAnnotation(methd, Base.class);
 * 可直接获得注解的注解(复合注解!)。没有返回null
 * @date 2018年07月09日 11:19
 */
public class TwoAnno {
    /**方法上使用的是复合注解*/
    @Two
    private String getAll(){
        return "ok";
    }

    /**被复合的注解*/
    @Target({ElementType.TYPE,ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Base{
        public String value() default "";
    }

    /**复合注解**/
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Base("haha")
    @interface Two{

    }

    /**
     * 复合注解的解析
     */
    public void test2() throws NoSuchMethodException, SecurityException{
        Class<TwoAnno> x = TwoAnno.class;
        Method methd = x.getDeclaredMethod("getAll", new Class[]{});
        /**声明的注解*/
        Annotation[] anns = methd.getDeclaredAnnotations();
        Annotation a = null;
        for (Annotation ann : anns) {
            if (ann.annotationType() == Base.class) {
                System.out.println("11111111");
                a = ann;
            }
        }
        if(a==null){
            /**演示只有2层的，多层需要递归处理*/
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
            System.out.println("没找到注解");
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
