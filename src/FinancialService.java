public class FinancialService {

    public void withdraw(Customer customer, double sum, String currency) {
        Account account = customer.getAccount();

        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }

        calculateMoney(customer, sum, account.getType().isPremium());
    }

    private void calculateMoney(Customer customer, double sum, boolean isPremium) {
        switch (customer.getCustomerType()) {
            case COMPANY:
                calculateMoneyByCompany(customer, sum, isPremium);
                break;
            case PERSON:
                calculateMoneyByPerson(customer.getAccount(), sum);
                break;
        }
    }

    private void calculateMoneyByCompany(Customer customer, double sum, boolean isPremium) {
        Account account = customer.getAccount();
        double discount = customer.getCompanyOverdraftDiscount();
        if (account.getMoney() < 0) {
            double overdraftFee = sum * account.overdraftFee() * discount;
            account.setMoney(account.getMoney() - sum - (isPremium ? overdraftFee / 2 : overdraftFee));
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }

    private void calculateMoneyByPerson(Account account, double sum) {
        if (account.getMoney() < 0) {
            account.setMoney(account.getMoney() - sum - sum * account.overdraftFee());
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }
}
