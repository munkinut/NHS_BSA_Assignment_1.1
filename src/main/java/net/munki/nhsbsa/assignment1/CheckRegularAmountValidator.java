package net.munki.nhsbsa.assignment1;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckRegularAmountValidator implements ConstraintValidator<CheckRegularAmount, String> {
   public void initialize(CheckRegularAmount constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return false;
   }
}
