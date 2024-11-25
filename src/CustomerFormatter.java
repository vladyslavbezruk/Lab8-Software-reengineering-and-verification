public class CustomerFormatter {

    public String printCustomerDaysOverdrawn(Customer customer) {
        String fullName = customer.getName() + " " + customer.getSurname() + " ";
        Account account = customer.getAccount();
        return fullName + "Account: IBAN: " + account.getIban() + ", Days Overdrawn: " + account.getDaysOverdrawn();
    }

    public String printCustomerMoney(Customer customer) {
        String fullName = customer.getName() + " " + customer.getSurname() + " ";
        Account account = customer.getAccount();
        return fullName + "Account: IBAN: " + account.getIban() + ", Money: " + account.getMoney();
    }

    public String printCustomerAccount(Customer customer) {
        Account account = customer.getAccount();
        return "Account: IBAN: " + account.getIban() + ", Money: "
                + account.getMoney() + ", Account type: " + account.getType();
    }
}
