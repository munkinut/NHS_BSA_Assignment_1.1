package net.munki.nhsbsa.assignment1;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularAmountTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void regularAmountIsInvalid() {
        RegularAmount ra = new RegularAmount();

        Set<ConstraintViolation<RegularAmount>> constraintViolations =
                validator.validate( ra );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "Regular Amount is invalid.", constraintViolations.iterator().next().getMessage() );
    }

}
