public class Money {
    private double amount;
    private Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void add(Money money) {
        if (this.currency.equals(money.getCurrency())) {
            this.amount += money.getAmount();
        } else {
            throw new RuntimeException("Currency mismatch");
        }
    }

    public void subtract(Money money) {
        if (this.currency.equals(money.getCurrency())) {
            this.amount -= money.getAmount();
        } else {
            throw new RuntimeException("Currency mismatch");
        }
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
