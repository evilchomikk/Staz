package org.example;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFormat {
    String dateFormat() default "yyyy-mm-dd";

}
