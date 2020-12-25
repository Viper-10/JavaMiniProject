package Runner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import Essentials.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Map<Pair, Account> listOfAccounts = new HashMap<>();
    public static Map<Pair, Card> listOfCards = new HashMap<>();
    public static HashSet<Customer> allCustomers = new HashSet<>();

    public static void main(String[] args) {

        FileSystem.RetriveDataFromFile();
        //setting up fresh account number to generate
        long newNum = 1;
        for(Pair p:listOfAccounts.keySet()){
            newNum = Math.max(newNum,listOfAccounts.get(p).getAccNo());
        }
        newNum++;
        ICICCard.setS_accNo(newNum);
        SBICard.setS_accNo(newNum);

        while(true){

            for(Pair p:listOfAccounts.keySet())
                System.out.println(p.bankName + " " + listOfAccounts.get(p).getAccNo());
            System.out.println("******************************");
            for(Customer c:allCustomers){
                System.out.println(c.getName());
            }
            System.out.println("Select an option: ");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Reset Pin");
            System.out.println("6. Cancel");

            int option = input.nextInt();
            if(option == 6) {
                FileSystem.StoreDataToFile();
                break;
            }

            switch(option){
                case 1 :
                    System.out.println("Enter customer name : ");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.println("Enter customer age : ");
                    int age = input.nextInt();

                    Card tempC = null;
                    boolean correctOption = false;

                    while (!correctOption) {
                        System.out.println("\nChoose Bank \n1. SBI\n2. ICIC");
                        int secondOption = input.nextInt();

                        switch (secondOption) {
                            case 1 -> {
                                tempC = new SBICard();
                                correctOption = true;
                            }
                            case 2 -> {
                                tempC = new ICICCard();
                                correctOption = true;
                            }
                            default ->
                                System.out.println("\nSelect Correct Option!");

                        }
                    }

                    System.out.println("Account Created successfully... ");
                    System.out.println("Your Account Number is : " + tempC.getAccNo());
                    System.out.println("Your Pin Number is : " + tempC.getPinNo());
                    System.out.println("\n");

                    listOfCards.put(new Pair(tempC.getBankName(), tempC.getAccNo()), tempC);
                    Account acc = new Account(tempC.getAccNo());
                    //Creating a customer
                    Customer customer = new Customer(name,age,tempC,acc);
                    allCustomers.add(customer);
                    listOfAccounts.put(new Pair(tempC.getBankName(), tempC.getAccNo()), acc);
                    System.out.println(listOfCards.size());
                    break;

                case 2 :
                    Check.checkCardCredentials();
                    break;

                case 3 :
                    Check.checkCardCredentials();
                    break;

                case 4 :
                    Check.checkCardCredentials();
                    break;

                case 5 :
                    Check.checkCardCredentials();
                    break;

            }
        }
    }
}
