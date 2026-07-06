public class BankApp {
    public static void main(String[] args){
        Bank bank=new Bank("Semicolon Bank");

        bank.registerCustomer("Edmond","1234",1001);
        bank.registerCustomer("John","2222",1002);

        try{
            bank.deposit(1001,5000);

            System.out.println(bank.checkBalance(1001,"1234"));

            bank.transfer(1001,1002,2000,"1234");

            System.out.println(bank.checkBalance(1001,"1234"));
            System.out.println(bank.checkBalance(1002,"2222"));
        }

        catch(IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}
