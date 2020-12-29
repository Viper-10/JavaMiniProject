package Threads;

import Essentials.*;
import CustomExceptions.*;

import Runner.Check;
import Runner.FileSystem;
import Runner.Pair;
import static  Runner.Main.*;

import static Runner.Colors.*;

public class ATMThread implements Runnable{
    @Override
    public void run() {
        System.out.println(TEXT_PURPLE + "Select an option: ");
        System.out.println("1. Create Account");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Check balance");
        System.out.println("5. Transfer");
        System.out.println("6. Reset Pin");
        System.out.println("7. Print ");
        System.out.println("8. Exit\n" + TEXT_RESET);

        int option = input.nextInt();
        System.out.println();

        Card tempC = null;

        switch (option) {
            case 1 -> {
                try {
                    Runner.Main.createCustomerAndAccount(tempC);
                } catch (UnderAgeException e) {
                    e.printStackTrace();
                } finally {
                    FileSystem.StoreDataToFile();
                }
            }
            case 2 -> {
                tempC = Check.checkCardCredentials();
                if(tempC != null) {
                    try{
                        tempC.withDraw();
                    }catch(NotEnoughBalanceException e){
                        System.out.println(e);
                    }finally{
                        FileSystem.StoreDataToFile();
                    }
                }
            }
            case 3 -> {
                tempC = Check.checkCardCredentials();
                if(tempC != null) tempC.deposit();
                FileSystem.StoreDataToFile();
            }
            case 4 -> {
                tempC = Check.checkCardCredentials();
                if(tempC != null) tempC.checkBalance();
            }
            case 5 -> {
                tempC = Check.checkCardCredentials();
                if (tempC != null) {
                    Account receiverAccount = Check.checkTransferAccountCredentials();
                    try {
                        tempC.transfer(receiverAccount);
                    } catch (NotEnoughBalanceException e) {
                        e.printStackTrace();
                    } finally {
                        FileSystem.StoreDataToFile();
                    }
                }
            }

            case 6 -> {
                tempC = Check.checkCardCredentials();
                if (tempC != null){
                    tempC.resetPin();
                    System.out.println(TEXT_PURPLE + "Your PIN number has been changed successfully!!!" + TEXT_RESET);
                }

                FileSystem.StoreDataToFile();
            }

            case 7 ->{
                System.out.println(TEXT_RED + "\n\nALREADY EXISTING ACCOUNTS\n");

                for(Pair p:listOfAccounts.keySet())
                    System.out.println(TEXT_YELLOW + "Bank Name: " + TEXT_WHITE + p.bankName + " " + TEXT_YELLOW + " \tAccount Number : " + TEXT_WHITE + listOfAccounts.get(p).getAccNo());
                System.out.println("\n");

                for(Customer c:allCustomers){
                    System.out.println(TEXT_YELLOW + "Customer Name  : " + TEXT_WHITE + c.getName() + TEXT_YELLOW + " \t--> Account Number: " + TEXT_WHITE + c.getAcc().getAccNo());
                }
            }

            case 8 ->{
                FileSystem.StoreDataToFile();
            }

            default -> System.out.println("Enter a valid option!");
        }

        System.out.println("\n");
        System.out.println("******************************************************************\n\n");

    }
}
