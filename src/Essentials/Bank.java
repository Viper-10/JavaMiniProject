package Essentials;

import java.util.LinkedList;
import java.util.List;

public abstract class Bank{
    String bankName;
    List<Account> accounts = new LinkedList<>();

    void addAcc(Account acc){
        accounts.add(acc);
        System.out.println("Thanks for creating a bank account!!");
        System.out.println("On behalf of " + bankName + " we welcome you!!!");
    }


}
