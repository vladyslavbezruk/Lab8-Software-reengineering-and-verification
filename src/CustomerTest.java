import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    @Test
    public void testPrintCustomerAccountNormal() throws Exception {
        Customer customer = getPersonWithAccount(false);
        CustomerFormatter customerFormatter = new CustomerFormatter();
        assertThat(customerFormatter.printCustomerAccount(customer), is("Account: IBAN: RO023INGB434321431241, Money: 34.0, Account type: normal"));
    }

    private Customer getPersonWithAccount(boolean premium) {
        AccountType accountType = new AccountType(premium);
        Account account = new Account(accountType, 9);
        Customer customer = new Customer("danix", "dan", "dan@mail.com", CustomerType.PERSON, account);
        account.setIban("RO023INGB434321431241");
        account.setMoney(34.0);
        account.setCurrency("EUR");
        return customer;
    }
}
