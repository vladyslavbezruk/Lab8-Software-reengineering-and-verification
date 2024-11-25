public class FinancialService {

    public void withdraw(Customer customer, double amount, String currency) {
        Account account = customer.getAccount();

        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Currency mismatch: " + currency + " is not supported.");
        }

        processWithdrawal(customer, amount, account.getType().isPremium());
    }

    private void processWithdrawal(Customer customer, double amount, boolean isPremiumAccount) {
        if (customer.getCustomerType() == CustomerType.COMPANY) {
            handleCompanyWithdrawal(customer, amount, isPremiumAccount);
        } else if (customer.getCustomerType() == CustomerType.PERSON) {
            handlePersonalWithdrawal(customer.getAccount(), amount);
        }
    }

    private void handleCompanyWithdrawal(Customer customer, double amount, boolean isPremiumAccount) {
        Account account = customer.getAccount();
        double discount = customer.getCompanyOverdraftDiscount();

        if (isAccountOverdrawn(account)) {
            double overdraftFee = calculateOverdraftFee(amount, account, discount, isPremiumAccount);
            account.setMoney(account.getMoney() - amount - overdraftFee);
        } else {
            account.setMoney(account.getMoney() - amount);
        }
    }

    private void handlePersonalWithdrawal(Account account, double amount) {
        if (isAccountOverdrawn(account)) {
            double overdraftFee = calculateOverdraftFee(amount, account, 1, false);
            account.setMoney(account.getMoney() - amount - overdraftFee);
        } else {
            account.setMoney(account.getMoney() - amount);
        }
    }

    private boolean isAccountOverdrawn(Account account) {
        return account.getMoney() < 0;
    }

    private double calculateOverdraftFee(double amount, Account account, double discount, boolean isPremiumAccount) {
        double baseFee = amount * account.overdraftFee() * discount;
        return isPremiumAccount ? baseFee / 2 : baseFee;
    }
}