package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class LengthValidator implements ConstraintValidator<Length, List> {

    private int length;

    @Override
    public void initialize(Length constraintAnnotetion) {
        this.length = constraintAnnotetion.value();
    }

    @Override
    public boolean isValid(List s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        return s.size()<=length;
    }
}
