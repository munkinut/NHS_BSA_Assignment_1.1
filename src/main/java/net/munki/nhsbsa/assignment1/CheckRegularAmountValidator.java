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

      try {
         pence = Integer.parseInt(amount) * 100;
      }
      catch (NumberFormatException e) {
         return true;
      }

      if (    frequency == null ||
              frequency.equals(Frequency.WEEK) ||
              frequency.equals(Frequency.MONTH)
      ) return true;

      int weeks = 0;

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

   private boolean isValidPence(int weeks, long pence) {
      return (pence % weeks == 0);
   }

}
