package Essentials;
import Runner.Main;

import java.io.Serial;
import java.io.Serializable;
import static Runner.Colors.*;
public class SBICard implements Card, Serializable {
    @Serial
    private static final long serialVersionUID = -1572058113136644630L;
    private final String bankName;
    private int pinNo;
    private final long accNo;
    private static int s_pinNo;
    private static long s_accNo;

    public SBICard() {
        pinNo = ++s_pinNo;
        accNo = ++s_accNo;
        bankName = "SBI";
    }

    public SBICard(ICICCard copy){
        this.pinNo = copy.getPinNo();
        this.accNo = copy.getAccNo();
        this.bankName = copy.getBankName();
    }

    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
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
    public String getBankName() {
        return bankName;
    }

    @Override
    public void accessGranted(){
        System.out.println(TEXT_GREEN + "ACCESS GRANTED" + TEXT_RESET);
    }

    @Override
    public boolean checkDetails(int pinNo){

        if(pinNo != this.pinNo) {
            System.out.println(TEXT_RED + "ACCESS DENIED, WRONG PIN NUMBER!!!" + TEXT_RESET );
            return false;
        }

        return true;
    }

    public static void setS_pinNo(int s_pinNo) {
        SBICard.s_pinNo = s_pinNo;
    }

    public static void setS_accNo(long s_accNo) {
        SBICard.s_accNo = s_accNo;
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
