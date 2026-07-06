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
            if(account.getNumber() ==  number){
                return account;
            }
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




    
}
