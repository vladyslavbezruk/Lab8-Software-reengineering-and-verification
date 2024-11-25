public class FinancialService {
    public void withdraw(Customer customer, Money amount) {
        Account account = customer.getAccount();
        if (!account.getMoney().getCurrency().equals(amount.getCurrency())) {
            throw new RuntimeException("Currency mismatch: " + amount.getCurrency() + " is not supported.");
        }

        double discount = customer.getCustomerType() == CustomerType.COMPANY
                ? customer.getCompanyOverdraftDiscount()
                : 1;

        OverdraftDiscount overdraftDiscount = new OverdraftDiscount(discount);
        account.withdraw(amount, overdraftDiscount);
    }
}
