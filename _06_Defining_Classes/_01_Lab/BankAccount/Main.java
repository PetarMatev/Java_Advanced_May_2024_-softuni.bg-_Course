package Java_Advanced_May_2024._06_Defining_Classes._01_Lab.BankAccount;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, BankAccount> listOfBankAccounts = new TreeMap<>();

        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] info = command.split("\\s+");
            String instruction = info[0];

            if (instruction.equals("Create")) {

                BankAccount bankAccount = new BankAccount();
                listOfBankAccounts.putIfAbsent(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created%n", bankAccount.getId());

            } else if (instruction.equals("Deposit")) {
                int currentID = Integer.parseInt(info[1]);

                if (!listOfBankAccounts.containsKey(currentID)) {
                    System.out.println("Account does not exist");
                } else {
                    double amount = Double.parseDouble(info[2]);
                    listOfBankAccounts.get(currentID).deposit(amount);
                    System.out.printf("Deposited %.0f to ID%d%n", amount, currentID);
                }
            } else if (instruction.equals("SetInterest")) {

                double interest = Double.parseDouble(info[1]);
                BankAccount.setInterestRate(interest);

            } else if (instruction.equals("GetInterest")) {
                int currentID = Integer.parseInt(info[1]);

                if (!listOfBankAccounts.containsKey(currentID)) {
                    System.out.println("Account does not exist");
                } else {
                    int years = Integer.parseInt(info[2]);
                    double currentInterest = listOfBankAccounts.get(currentID).getInterest(years);
                    System.out.printf("%.2f%n", currentInterest);
                }
            }

            command = scan.nextLine();
        }
    }
}
