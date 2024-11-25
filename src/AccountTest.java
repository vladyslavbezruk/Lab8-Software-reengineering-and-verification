import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    @Test
    public void testBankchargePremiumLessThanAWeek() {
        Account account = getPremiumAccount(5);
        assertThat(account.bankcharge(), is(14.5));
    }

    @Test
    public void testGetAccountDetails() {
        Account account = getPremiumAccount(5);
        account.setIban("RO123456");
        account.setMoney(new Money(100.0, "USD"));
        assertThat(account.getAccountDetails(), is("Account: IBAN: RO123456, Money: 100.0 USD, Account type: premium"));
    }

    @Test
    public void testWithdrawWithOverdraft() {
        Account account = getPremiumAccount(0);
        account.setMoney(new Money(-50.0, "USD"));
        OverdraftDiscount discount = new OverdraftDiscount(0.5);
        account.withdraw(new Money(20.0, "USD"), discount);
        assertThat(account.getMoney().getAmount(), is(-70.5));
    }

    private Account getPremiumAccount(int daysOverdrawn) {
        AccountType premium = new AccountType(true);
        Money initialMoney = new Money(0.0, "USD");
        return new Account(premium, daysOverdrawn, initialMoney, "USD");
    }
}
