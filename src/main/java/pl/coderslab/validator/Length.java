package pl.coderslab.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    int value();
    String	message()	default	"Artykul nie moze byc przypisany do tak wielu kategorii.";
    Class<?>[]	groups()	default	{};
    Class<?	extends Payload>[]	payload()	default	{};
}
