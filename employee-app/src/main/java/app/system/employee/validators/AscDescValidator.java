package app.system.employee.validators;

import app.system.employee.validators.impl.AscDescValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AscDescValidatorImpl.class)
public @interface AscDescValidator {

    boolean required() default false;

    String message() default "Value must be ASC or DESC.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
