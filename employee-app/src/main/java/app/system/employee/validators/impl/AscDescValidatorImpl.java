package app.system.employee.validators.impl;

import app.system.employee.validators.AscDescValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class AscDescValidatorImpl implements ConstraintValidator<AscDescValidator, String> {

    private boolean required;

    @Override
    public void initialize(AscDescValidator constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.nonNull(s)) {
            return s.equals("ASC") || s.equals("DESC");
        }

        return !this.required;
    }
}
