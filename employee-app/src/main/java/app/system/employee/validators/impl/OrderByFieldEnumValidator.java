package app.system.employee.validators.impl;

import app.system.employee.enums.EmployeeOrderByFieldEnum;
import app.system.employee.validators.OrderByFieldEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderByFieldEnumValidator implements ConstraintValidator<OrderByFieldEnum, String> {

    private boolean required;
    private String message;

    @Override
    public void initialize(OrderByFieldEnum constraintAnnotation) {
        this.required = constraintAnnotation.required();
        this.message = "Order field must be one of: [" + Arrays.stream(EmployeeOrderByFieldEnum.values())
                                                               .map(EmployeeOrderByFieldEnum::name)
                                                               .collect(Collectors.joining(", ")) + "].";
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.buildConstraintViolationWithTemplate(this.message);
        if (Objects.nonNull(s)) {
            return Arrays.stream(EmployeeOrderByFieldEnum.values())
                         .anyMatch(f -> f.name().equals(s));
        }

        return !required;
    }
}
