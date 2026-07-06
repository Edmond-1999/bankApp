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



}
