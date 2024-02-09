package api.system.employee.validators;

import api.system.employee.validators.impl.AscDescValidator;
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
@Constraint(validatedBy = AscDescValidator.class)
public @interface AscDesc {

    boolean required() default false;

    String message() default "Value must be ASC or DESC.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
