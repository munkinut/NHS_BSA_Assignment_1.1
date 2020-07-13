package net.munki.nhsbsa.assignment1;

public class RegularAmount {
    private Frequency frequency;
    private String amount;

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

enum Frequency {
    WEEK, TWO_WEEK, FOUR_WEEK, MONTH, QUARTER, YEAR
}

