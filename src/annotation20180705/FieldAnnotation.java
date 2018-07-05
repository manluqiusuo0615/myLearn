package annotation20180705;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Description 自定义注解（实体类中的属性注解）
 * @author: Xiao ChangLu
 * @date:2017-9-4下午2:38:15
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)  //生命周期
public @interface FieldAnnotation {
	String value();
}
