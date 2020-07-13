package net.munki.nhsbsa.assignment1;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { CheckRegularAmountValidator.class })
@Documented
public @interface CheckRegularAmount {

    String message() default "Regular Amount is invalid.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
