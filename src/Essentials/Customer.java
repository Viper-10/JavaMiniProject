package Essentials;

public class Customer extends Person{
    private Card c;
    private Account acc;

    public Customer(String name, int age, Card c, Account acc) {
        super(name, age);
        this.c = c;
        this.acc = acc;
    }

    public Card getC() {
        return c;
    }

    public void setC(Card c) {
        this.c = c;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }
}