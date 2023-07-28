package org.example;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface TableOrder {
String sortByField();


}
