public class Account {

    private String iban;
    private AccountType type;
    private int daysOverdrawn;
    private double money;
    private String currency;
    private Customer customer;

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

    public void withdraw(double amount, double overdraftDiscount) {
        if (money < 0) {
            double overdraftFee = calculateOverdraftFee(amount, overdraftDiscount);
            setMoney(money - amount - overdraftFee);
        } else {
            setMoney(money - amount);
        }
    }

    private double calculateOverdraftFee(double amount, double discount) {
        double baseFee = amount * overdraftFee() * discount;
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

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
