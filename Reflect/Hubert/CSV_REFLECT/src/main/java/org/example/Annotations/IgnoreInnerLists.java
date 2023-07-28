package org.example.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Target({ElementType.TYPE_USE,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreInnerLists {

}
