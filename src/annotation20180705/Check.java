package annotation20180705;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Ф��·
 * @description
 * @date 2018��07��05�� 14:24
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    String value();
}
