package com.joinky.log.anotation;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

/**
 * @author Joinky
 */
@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRecord {

    String value() default "";
}
