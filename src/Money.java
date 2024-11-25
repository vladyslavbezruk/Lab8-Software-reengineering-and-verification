public class Money {
    private double amount;
    private String currency;

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
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
