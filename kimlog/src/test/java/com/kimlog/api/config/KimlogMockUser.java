package com.kimlog.api.config;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = KimlogMockSecurityContext.class)
public @interface KimlogMockUser {

    String name() default "김현우";

    String email() default "w009981@naver.com";

    String password() default "";
}
