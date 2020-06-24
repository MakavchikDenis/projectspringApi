package by.makavchik.projectspring.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CellPhone {
    String message() default "{Phone}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
