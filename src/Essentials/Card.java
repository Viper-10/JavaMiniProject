package Essentials;

import Runner.Check;
import Runner.Main;
import Runner.Pair;

import static Runner.Main.*;

public interface Card {
    String[] bankName = new String[]{"SBI", "ICIC"};

    void accessGranted();

    boolean checkDetails(int PinNo);

    long getAccNo();

    int getPinNo();

    String getBankName();

    public void resetPin();

    Account getAcc();

    default void withDraw() {
        synchronized (this) {
            Account accessedAccount = listOfAccounts.get(new Pair(getBankName(), getAccNo()));

            if (accessedAccount != null) {
                if (accessedAccount.getAccBalance() == 0) {
                    System.out.println("Your account balance is 0. You have to deposit first!");
                } else {
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount = Main.input.nextDouble();
                    if (withdrawAmount == 0) {
                        System.out.println("Aborting withdraw process!!!");
                    }
                    double currentBalance = accessedAccount.getAccBalance();
                    if (currentBalance >= withdrawAmount) {
                        accessedAccount.setAccBalance(currentBalance - withdrawAmount);
                        listOfAccounts.replace(new Pair(Check.bankName, Check.accNo), accessedAccount);
                        System.out.println("Amount " + withdrawAmount + " successfully withdrawn!");
                    } else {
                        System.out.println("Your account balance is lower than the entered amount.");
                        System.out.println("Aborting withdraw process!!!");
                    }
                }
            }
        }
    }

    default void deposit() {
            Account accessedAccount = listOfAccounts.get(new Pair(getBankName(), getAccNo()));
                if (accessedAccount != null) {
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount = Main.input.nextDouble();
                    double currentBalance = accessedAccount.getAccBalance();
                    accessedAccount.setAccBalance(currentBalance + depositAmount);
                    System.out.println("An amount of " + depositAmount + " Rs has been deposited successfully!!!");
                }
        }

        default void checkBalance(){
            Account accessedAccount = listOfAccounts.get(new Pair(getBankName(), getAccNo()));
            if (accessedAccount != null){
                double currentBalance = accessedAccount.getAccBalance();
                System.out.println("Your current balance is " + currentBalance + " Rs.");
            }
        }
        default void transfer(Account receiverAccount) {
            synchronized (this) {
                Account accessedAccount = listOfAccounts.get(new Pair(getBankName(), getAccNo()));

                if (accessedAccount != null && receiverAccount != null) {
                    System.out.println("Enter amount to be transferred:");
                    double transferAmount = Main.input.nextDouble();

                    if (transferAmount == 0) {
                        System.out.println("Aborting withdraw process!!!");
                    }

                    double currentBalance = accessedAccount.getAccBalance();
                    double currentReceiverBalance = receiverAccount.getAccBalance();

                    if (currentBalance >= transferAmount) {
                        receiverAccount.setAccBalance(currentReceiverBalance + transferAmount);
                        accessedAccount.setAccBalance(currentBalance - transferAmount);
                        listOfAccounts.replace(new Pair(Check.bankName, Check.accNo), accessedAccount);
                        listOfAccounts.replace(new Pair(Check.receiverBankName, Check.receiverAccountNo), receiverAccount);
                        System.out.println("Amount of Rs. " + transferAmount + " successfully transferred!");
                    } else {
                        System.out.println("Your account balance is lower than the entered amount.");
                        System.out.println("Aborting withdraw process!!!");
                    }
                }
            }
    }
}
