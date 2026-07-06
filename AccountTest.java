import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void newAccountBalanceIsZeroTest() {

        Account account = new Account("John", "1234", 1);
        int balance = account.checkBalance("1234");
        assertEquals(0, balance);

    }

    @Test
    public void depositIncreasesBalanceTest() {
        Account account = new Account("John", "1234", 1);
        account.deposit(5000);
        assertEquals(5000, account.checkBalance("1234"));
    }

    @Test
    public void depositNegativeAmountThrowsExceptionTest() {

        Account account = new Account("John", "1234", 1);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-500));

    }

    @Test
    public void withdrawReducesBalanceTest() {

        Account account = new Account("John", "1234", 1);
        account.deposit(6000);
        account.withdraw(2000, "1234");
        assertEquals(4000, account.checkBalance("1234"));

    }

    @Test
    public void withdrawWithWrongPinThrowsExceptionTest() {

        Account account = new Account("John", "1234", 1);
        account.deposit(5000);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1000, "1111"));

    }

    @Test
    public void withdrawMoreThanBalanceThrowsExceptionTest() {

        Account account = new Account("John", "1234", 1);
        account.deposit(2000);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(5000, "1234"));

    }

    @Test
    public void checkBalanceWithWrongPinThrowsExceptionTest() {

        Account account = new Account("John", "1234", 1);
        assertThrows(IllegalArgumentException.class, () -> account.checkBalance("9999"));

    }
}
