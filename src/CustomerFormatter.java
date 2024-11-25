public class CustomerFormatter {

    public String printCustomerDaysOverdrawn(Customer customer) {
        return customer.getAccount().getDaysOverdrawnDetails();
    }

    public String printCustomerMoney(Customer customer) {
        return customer.getAccount().getCustomerDetails() + ", " + customer.getAccount().getAccountDetails();
    }

    public String printCustomerAccount(Customer customer) {
        return customer.getAccount().getAccountDetails();
    }
}
