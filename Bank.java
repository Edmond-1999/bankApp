import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Account> accounts;

    public Bank(String name){
        this.name=name;
        accounts = new ArrayList<>();
    }

    public Account registerCustomer(String name, String pin, int number){
        Account account = new Account(name,pin,number);
        accounts.add(account);
        return account;
    }

    public Account findAccount(int number){
        for(Account account:accounts){
            if(account.getNumber() ==  number) return account;
        }
        return null;
    }

    public void deposit(int number, int amount){
        Account account = findAccount(number);
        if(account == null) throw new IllegalArgumentException("Account not found.");
        account.deposit(amount);
    }

    public void withdraw(int number, int amount,String pin){
        Account account = findAccount(number);
        if(account == null) throw new IllegalArgumentException("Account not found.");
        account.withdraw(amount,pin);
    }

    public int checkBalance(int number, String pin){
        Account account = findAccount(number);
        if(account == null) throw new IllegalArgumentException("Account not found.");
        return account.checkBalance(pin);
    }

    public void transfer(int sender, int receiver, int amount, String pin){
        Account senderAccount = findAccount(sender);
        Account receiverAccount = findAccount(receiver);
        if(senderAccount == null || receiverAccount == null) throw new IllegalArgumentException("Account not found.");
        senderAccount.withdraw(amount,pin);
        receiverAccount.deposit(amount);
    }

    public void removeAccount(int number, String pin){
        Account account = findAccount(number);
        if(account == null) throw new IllegalArgumentException("Account not found.");
        account.checkBalance(pin);
        accounts.remove(account);
    }
}
