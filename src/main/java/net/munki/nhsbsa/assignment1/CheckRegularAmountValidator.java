package net.munki.nhsbsa.assignment1;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckRegularAmountValidator implements ConstraintValidator<CheckRegularAmount, RegularAmount> {

   @Override
   public void initialize(CheckRegularAmount checkRegularAmount) {
   }

   @Override
   public boolean isValid(RegularAmount regularAmount, ConstraintValidatorContext constraintValidatorContext) {

      return false;
   }

}
