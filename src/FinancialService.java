public class FinancialService {

    public void withdraw(Customer customer, double amount, String currency) {
        Account account = customer.getAccount();

        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Currency mismatch: " + currency + " is not supported.");
        }

        double discount = customer.getCustomerType() == CustomerType.COMPANY
                ? customer.getCompanyOverdraftDiscount()
                : 1;

        account.withdraw(amount, discount);
    }
}
