package Essentials;

import Runner.Main;

import java.io.Serial;
import java.io.Serializable;
import static Runner.Colors.*;

public class ICICCard implements Card, Serializable {
    @Serial
    private static final long serialVersionUID = 6470249712448579374L;
    private int pinNo;
    private final long accNo;
    private final String bankName;

    private static  int s_pinNo;
    private static long s_accNo;

    static{
        s_pinNo = 1000;
        s_accNo = 12345678;
    }

    public ICICCard() {
        pinNo = ++s_pinNo;
        accNo = ++s_accNo;
        bankName = "ICIC";
    }

    public ICICCard(ICICCard copy){
        this.pinNo = copy.getPinNo();
        this.accNo = copy.getAccNo();
        this.bankName = copy.getBankName();
    }

    public static void setS_pinNo(int s_pinNo) {
        ICICCard.s_pinNo = s_pinNo;
    }

    public static void setS_accNo(long s_accNo) {
        ICICCard.s_accNo = s_accNo;
    }

    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
    }

    @Override
    public void accessGranted() {
        System.out.println(TEXT_GREEN + "ACCESS GRANTED" + TEXT_RESET);
    }

    @Override
    public boolean checkDetails(int pinNo) {
        if(pinNo != this.pinNo) {
            System.out.println(TEXT_RED + "ACCESS DENIED , WRONG PIN NUMBER!!!" + TEXT_RESET);
            return false;
        }
        return true;
    }

    @Override
    public String getBankName() {
        return bankName;
    }

    @Override
    public int getPinNo() {
        return pinNo;
    }

    @Override
    public long getAccNo() {
        return accNo;
    }

    @Override
    public void resetPin() {
        System.out.println("Enter your new PIN number:");
        int newPin = Main.input.nextInt();
        setPinNo(newPin);
    }

    @Override
    public Account getAcc() {
        return null;
    }
}
