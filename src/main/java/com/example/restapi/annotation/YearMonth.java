package com.example.restapi.annotation;

import com.example.restapi.validator.YearMonthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {YearMonthValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface YearMonth {
    String message() default "날짜 양식이 맞지 않습니다. ex) 202009";
    String regexp() default "^\\d{6}$";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}