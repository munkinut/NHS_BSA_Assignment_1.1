package net.munki.nhsbsa.play;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase checkCase) {
        this.caseMode = checkCase.cmvalue();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if ( object == null ) {
            return true;
        }

        if ( caseMode == CaseMode.UPPER ) {
            return object.equals( object.toUpperCase() );
        }
        else {
            return object.equals( object.toLowerCase() );
        }
    }
}