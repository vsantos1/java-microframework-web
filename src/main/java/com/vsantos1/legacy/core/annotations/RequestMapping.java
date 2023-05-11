package com.vsantos1.legacy.core.annotations;

import com.vsantos1.legacy.core.enums.ContentType;
import com.vsantos1.legacy.core.enums.HttpMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    HttpMethod method() default HttpMethod.GET;

    String value() default "";

    ContentType contentType() default ContentType.APPLICATION_JSON;
}
