package net.munki.nhsbsa.assignment1;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckRegularAmountValidator implements ConstraintValidator<CheckRegularAmount, RegularAmount> {

   @Override
   public void initialize(CheckRegularAmount checkRegularAmount) {
   }

   @Override
   public boolean isValid(RegularAmount regularAmount, ConstraintValidatorContext constraintValidatorContext) {

      String amount = regularAmount.getAmount();
      Frequency frequency = regularAmount.getFrequency();
      long pence;

      // If amount is blank or non-numeric, return valid
      try {
         pence = Integer.parseInt(amount) * 100;
      }
      catch (NumberFormatException e) {
         return true;
      }

      // If frequency is null, WEEK or MONTH, return valid
      if (    frequency == null ||
              frequency.equals(Frequency.WEEK) ||
              frequency.equals(Frequency.MONTH)
      ) return true;

      int weeks = 0;

      // Ensure enum keys refer to numerics for weeks
      switch (frequency) {
         case TWO_WEEK:
            weeks = 2;
            break;
         case FOUR_WEEK:
            weeks = 4;
            break;
         case QUARTER:
            weeks = 13;
            break;
         case YEAR:
            weeks = 52;
            break;
      }
      return isValidPence(weeks, pence);
   }

   // Simple mod operation to determine if pence is valid
   private boolean isValidPence(int weeks, long pence) {
      return (pence % weeks == 0);
   }

}
