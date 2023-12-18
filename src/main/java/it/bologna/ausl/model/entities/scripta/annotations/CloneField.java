package it.bologna.ausl.model.entities.scripta.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *
 * @author Michele D'Onza
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CloneField {
    //public boolean value() default true;
    public boolean deep() default false;
}





