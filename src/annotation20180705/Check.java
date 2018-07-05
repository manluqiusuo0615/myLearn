package annotation20180705;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 肖长路
 * @description
 * @date 2018年07月05日 14:24
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    String value();
}
