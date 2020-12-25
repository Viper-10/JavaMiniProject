package Runner;

import Essentials.Account;
import Essentials.Card;
import Essentials.Customer;

import java.io.*;
import java.util.HashSet;
import java.util.Map;

public class FileSystem {
    private static final String CardFile = "cards.ser";
    private static final String AccountFile = "accounts.ser";
    private static final String Customers = "customers.ser";

    public static void StoreDataToFile(){
        try{
            FileOutputStream file = new FileOutputStream(CardFile);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(Main.listOfCards);
            file.close();

            file = new FileOutputStream(AccountFile);
            out = new ObjectOutputStream(file);
            out.writeObject(Main.listOfAccounts);
            file.close();

            file = new FileOutputStream(Customers);
            out = new ObjectOutputStream(file);
            out.writeObject(Main.allCustomers);
            file.close();

            out.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void RetriveDataFromFile(){
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(CardFile));
            Main.listOfCards = (Map<Pair, Card>) in.readObject();

            in = new ObjectInputStream(new FileInputStream(AccountFile));
            Main.listOfAccounts = (Map<Pair, Account>) in.readObject();

            in = new ObjectInputStream(new FileInputStream(Customers));
            Main.allCustomers = (HashSet<Customer>) in.readObject();

            in.close();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
