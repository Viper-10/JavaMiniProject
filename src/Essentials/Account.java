package Essentials;

public class Account {
    double accBalance;
    final long accNo;

    public Account(double accBalance, long accNo) {
        this.accBalance = accBalance;
        this.accNo = accNo;
    }

    public Account(long accNo) {
        this.accNo = accNo;
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
