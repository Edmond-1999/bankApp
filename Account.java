public class Account {

    private String name;
    private int balance;
    private String pin;
    private int number;

    public Account(String name, String pin, int number) {
        this.name = name;
        this.pin = pin;
        this.number = number;
        balance = 0;
    }

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be greater than zero.");
        balance += amount;
    }

    public void withdraw(int amount, String enteredPin) {
        if (!pin.equals(enteredPin)) throw new IllegalArgumentException("Incorrect PIN.");
        if (amount <= 0) throw new IllegalArgumentException("Amount must be greater than zero.");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds.");
        balance -= amount;
    }

    public int checkBalance(String enteredPin) {
        if (!pin.equals(enteredPin)) throw new IllegalArgumentException("Incorrect PIN.");
        return balance;
    }

    public int getNumber() { return number; }
    public String getName() { return name; }
}
