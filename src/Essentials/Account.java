package Essentials;

public class Account {
    double accBalance;
<<<<<<< HEAD
    final long accNo;
=======
    long accNo;
>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b

    public Account(double accBalance, long accNo) {
        this.accBalance = accBalance;
        this.accNo = accNo;
    }

<<<<<<< HEAD
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


=======
    public Account() {
        accBalance = 0;
        accNo = 0;
    }

>>>>>>> 37c94c7664d96e83cf6514e22fdfd499c9282c0b
}
