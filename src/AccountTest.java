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
        account.setMoney(100.0);
        assertThat(account.getAccountDetails(), is("Account: IBAN: RO123456, Money: 100.0, Account type: premium"));
    }

    @Test
    public void testWithdrawWithOverdraft() {
        Account account = getPremiumAccount(0);
        account.setMoney(-50.0);
        account.withdraw(20.0, 0.5);
        assertThat(account.getMoney(), is(-70.5)); // -50 - 20 (немає штрафу через преміум)
    }

    private Account getPremiumAccount(int daysOverdrawn) {
        AccountType premium = new AccountType(true);
        return new Account(premium, daysOverdrawn);
    }
}
