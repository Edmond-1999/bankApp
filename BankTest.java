import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank("Semicolon Bank");
    }

    @Test
    public void registerCustomerCreatesAccountTest() {
        bank.registerCustomer("John", "1234", 1);
        Account account = bank.findAccount(1);
        assertNotNull(account);
    }

    @Test
    public void depositIntoAccountTest() {
        bank.registerCustomer("John", "1234", 1);
        bank.deposit(1, 5000);
        assertEquals(5000, bank.checkBalance(1, "1234"));
    }

    @Test
    public void withdrawFromAccountTest() {
        bank.registerCustomer("John", "1234", 1);
        bank.deposit(1, 6000);
        bank.withdraw(1, 2000, "1234");
        assertEquals(4000, bank.checkBalance(1, "1234"));
    }

    @Test
    public void transferMovesMoneyBetweenAccountsTest() {
        bank.registerCustomer("John", "1234", 1);
        bank.registerCustomer("Mary", "5678", 2);
        bank.deposit(1, 10000);
        bank.transfer(1, 2, 3000, "1234");
        assertEquals(7000, bank.checkBalance(1, "1234"));
        assertEquals(3000, bank.checkBalance(2, "5678"));
    }

    @Test
    public void removeAccountDeletesAccountTest() {
        bank.registerCustomer("John", "1234", 1);
        bank.removeAccount(1, "1234");
        assertNull(bank.findAccount(1));
    }

    @Test
    public void depositingIntoUnknownAccountThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> bank.deposit(10, 5000));
    }

    @Test
    public void withdrawingWithWrongPinThrowsExceptionTest() {
        bank.registerCustomer("John", "1234", 1);
        bank.deposit(1, 5000);
        assertThrows(IllegalArgumentException.class, () -> bank.withdraw(1, 1000, "1111"));
    }

    @Test
    public void transferWithInsufficientFundsThrowsExceptionTest() {
        bank.registerCustomer("John", "1234", 1);
        bank.registerCustomer("Mary", "5678", 2);
        bank.deposit(1, 1000);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(1, 2, 5000, "1234"));
    }
}
