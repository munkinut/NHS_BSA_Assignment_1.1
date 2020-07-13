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
    public void amountNonNumeric() {
        RegularAmount ra = new RegularAmount();
        ra.setFrequency(Frequency.WEEK);
        ra.setAmount("abcd");
        Set<ConstraintViolation<RegularAmount>> constraintViolations =
                validator.validate( ra );
        assertEquals( 0, constraintViolations.size() );
    }

    @Test
    public void amountBlank() {
        RegularAmount ra = new RegularAmount();
        ra.setFrequency(Frequency.WEEK);
        ra.setAmount("");
        Set<ConstraintViolation<RegularAmount>> constraintViolations =
                validator.validate( ra );
        assertEquals( 0, constraintViolations.size() );
    }

    @Test
    public void frequencyWeek() {
        RegularAmount ra = new RegularAmount();
        ra.setFrequency(Frequency.WEEK);
        ra.setAmount("1000");
        Set<ConstraintViolation<RegularAmount>> constraintViolations =
                validator.validate( ra );
        assertEquals( 0, constraintViolations.size() );
    }

    @Test
    public void frequencyMonth() {
        RegularAmount ra = new RegularAmount();
        ra.setFrequency(Frequency.MONTH);
        ra.setAmount("1000");
        Set<ConstraintViolation<RegularAmount>> constraintViolations =
                validator.validate( ra );
        assertEquals( 0, constraintViolations.size() );
    }

    @Test
    public void amountValid() {
        RegularAmount ra = new RegularAmount();
        ra.setFrequency(Frequency.TWO_WEEK);
        ra.setAmount("1000");
        Set<ConstraintViolation<RegularAmount>> constraintViolations =
                validator.validate( ra );
        assertEquals( 0, constraintViolations.size() );
    }

    @Test
    public void amountInvalid() {
        RegularAmount ra = new RegularAmount();
        ra.setFrequency(Frequency.QUARTER);
        ra.setAmount("1003");
        Set<ConstraintViolation<RegularAmount>> constraintViolations =
                validator.validate( ra );
        assertEquals( 1, constraintViolations.size() );
        assertEquals( "Regular Amount is invalid.", constraintViolations.iterator().next().getMessage() );
    }


}
