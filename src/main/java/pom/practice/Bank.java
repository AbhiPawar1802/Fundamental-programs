package pom.practice;

class BankAccount{
    protected String accountNumber;
    protected Double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited : "+ amount +", New Balance: "+balance);
    }

    public void withdraw(double amount) {
        if(amount>balance) {
            System.out.println("Insufficient Balance.");
        }else {
            balance -=amount;
            System.out.println("Withdrawn: "+amount+", New Balance: "+ balance);
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: "+ accountNumber +", Balance: "+ balance);
    }
}

class SavingsAccount extends BankAccount{

    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest Added: "+ interest + ", New Balance: " + balance);
    }

}

class CurrentAccount extends BankAccount{
 
    private double overDraftLimit;
    public CurrentAccount(String accountNumber, double balance, double overDraftLimit) {
        super(accountNumber, balance);
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(amount>balance + overDraftLimit) {
            System.out.println("Overdraft limit exceeded");
        }else {
            balance -= amount;
            System.out.println("Withdrawn: "+ amount +", New Balance: "+balance);
        }
    }
}

public class Bank {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SavingsAccount savings = new SavingsAccount("SA12345", 5000, 3.5);
        savings.displayBalance();
        savings.deposit(1000);
        savings.addInterest();
        savings.withdraw(2000);

        System.out.println();

        CurrentAccount current = new CurrentAccount("CA1234", 10000, 2000);
        current.displayBalance();
        current.withdraw(11000);
        current.withdraw(13000);

    }

}

