package Essentials;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = -2745912589877904941L;
    double accBalance;
    final long accNo;
    public Account(double accBalance, long accNo) {
        this.accBalance = accBalance;
        this.accNo = accNo;
    }

    public Account(long accNo) {
        this.accNo = accNo;
        this.accBalance = 0;
    }

    public Account(Account copyAccount){
        this.accNo = copyAccount.accNo;
        this.accBalance = copyAccount.accBalance;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public long getAccNo() {
        return accNo;
    }
}
