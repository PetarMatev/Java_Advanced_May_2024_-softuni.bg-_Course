package Java_Advanced_May_2024._06_Defining_Classes._01_Lab.BankAccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    public static void setBankAccountCount(int bankAccountCount) {
        BankAccount.bankAccountCount = bankAccountCount;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    BankAccount() {
        this.id = bankAccountCount++;
    }

    public int getId() {
        return this.id;
    }



    public void setBalance(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }


}
