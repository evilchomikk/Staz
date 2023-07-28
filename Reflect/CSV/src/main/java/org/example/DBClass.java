package org.example;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DBClass {
}
