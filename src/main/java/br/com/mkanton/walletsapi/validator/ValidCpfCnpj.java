package br.com.mkanton.walletsapi.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CpfCnpjValidator.class)
public @interface ValidCpfCnpj {
    String message() default "CPF or CNPJ is invalid";
            Class<?>[] groups() default {};
            Class<? extends Payload>[] payload() default {};
}
