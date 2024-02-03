package app.system.employee.validators.impl;

import app.system.employee.validators.DateFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {

    private boolean required;
    private String message;
    private String pattern;

    @Override
    public void initialize(DateFormat constraintAnnotation) {
        this.message = constraintAnnotation.message();
        this.required = constraintAnnotation.required();
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.nonNull(s)) {
            if (this.pattern.length() != s.length()) {
                return false;
            }
            try {
                var format = new SimpleDateFormat(this.pattern);
                format.parse(s);
            } catch (ParseException e) {
                return false;
            }
            return true;
        }

        return !required;
    }
}
