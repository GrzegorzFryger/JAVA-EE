package logic;

import java.io.Serializable;
import java.util.Random;

public class LoanNumberGenerator implements Serializable
{

    private int numer;

    public LoanNumberGenerator()
    {

        Random rand = new Random();

        this.numer = rand.nextInt(1000000) + 1;
    }

    public int getNumer() {

        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }
}
