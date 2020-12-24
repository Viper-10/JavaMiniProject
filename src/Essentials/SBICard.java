package Essentials;

import java.io.Serializable;

public class SBICard implements Card, Serializable {
    private final String bankName;
    private final int pinNo;
    private final long accNo;
    private static int s_pinNo;
    private static long s_accNo;

    public SBICard() {
        pinNo = ++s_pinNo;
        accNo = ++s_accNo;
        bankName = "SBI";
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
        System.out.println("ACCESS GRANTED");
    }


    @Override
    public boolean checkDetails(int pinNo){

        if(pinNo != this.pinNo) {
            System.out.println("ACCESS DENIED, WRONG PIN NUMBER!!!");
            return false;
        }

        return true;
    }
}
