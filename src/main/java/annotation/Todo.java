package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解演示
 * Created by seyMour on 2016/8/24.
 * ☞Keenyoda☜
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Todo {

    enum Priority {LOW, MEDIUM, HIGH}

    enum Status {STARTED, NOT_STARTED}

    String author() default "Bob";

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTED;
}
