package Essentials;

import java.io.Serial;

public class Customer extends Person{
    @Serial
    private static final long serialVersionUID = -770010202900253107L;
    private Card c;
    private Account acc;

    public Customer(){
        super();
        c = null;
        acc = null;
    }

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
