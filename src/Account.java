public class Account {
    private String iban;
    private AccountType type;
    private int daysOverdrawn;
    private Money money;
    private Customer customer;

    public Account(AccountType type, int daysOverdrawn, Money money) {
        this.type = type;
        this.daysOverdrawn = daysOverdrawn;
        this.money = money;
    }

    public Account(AccountType type, int daysOverdrawn) {
        this.type = type;
        this.daysOverdrawn = daysOverdrawn;
    }

    public String getAccountDetails() {
        return "Account: IBAN: " + iban + ", Money: " + money + ", Account type: " + type.getDescription();
    }

    public String getCustomerDetails() {
        return customer.getName() + " " + customer.getSurname() + " (Email: " + customer.getEmail() + ")";
    }

    public String getDaysOverdrawnDetails() {
        return "Account: IBAN: " + iban + ", Days Overdrawn: " + daysOverdrawn;
    }

    public void withdraw(Money amount, OverdraftDiscount discount) {
        if (money.getAmount() < 0) {
            double overdraftFee = calculateOverdraftFee(amount, discount);
            money.subtract(new Money(amount.getAmount() + overdraftFee, amount.getCurrency()));
        } else {
            money.subtract(amount);
        }
    }

    private double calculateOverdraftFee(Money amount, OverdraftDiscount discount) {
        double baseFee = amount.getAmount() * overdraftFee() * discount.getDiscount();
        return type.isPremium() ? baseFee / 2 : baseFee;
    }

    public double overdraftFee() {
        return type.isPremium() ? 0.10 : 0.20;
    }

    public double bankcharge() {
        if (type.isPremium()) {
            return daysOverdrawn > 7
                    ? 10 + (daysOverdrawn - 7) * 0.85
                    : 10 + daysOverdrawn * 0.9;
        } else {
            return daysOverdrawn * 1.75;
        }
    }

    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getType() {
        return type;
    }
}
