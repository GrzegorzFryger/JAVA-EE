package logic;

import junit.framework.TestCase;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class CalculatorDescendingInstallmentTest extends TestCase {

    CalculatorDescendingInstallment cac;



    public void setUp() {
        cac = new CalculatorDescendingInstallment();

    }

    public void testCalculateDescendingInstallment()
    {

        assertEquals(2016.6666666666665,cac.calculateDescendingInstallment(2,2,4000,10,0));
    }

    public void testCalculateCapitalInstallment() {
    }

    public void testCalculateInstallmentInterest() {
    }
}