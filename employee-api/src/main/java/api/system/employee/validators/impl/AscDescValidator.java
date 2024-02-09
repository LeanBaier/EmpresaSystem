package api.system.employee.validators.impl;

import api.system.employee.validators.AscDesc;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class AscDescValidator implements ConstraintValidator<AscDesc, String> {

    private boolean required;

    @Override
    public void initialize(AscDesc constraintAnnotation) {
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
