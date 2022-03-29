package fraction;

import fraction.FractionImpl.*;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.jupiter.api.function.Executable;

import static fraction.FractionImpl.getGCD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class FractionImplTest {

    @Test // Tests the static method for obtaining the greatest common divisor used to normalise the fraction.
    public void testGetGCD (){
        int GCD1 = getGCD(1,2);
        assertEquals(GCD1, 1);
        int GCD2 = getGCD(3,6);
        assertEquals(GCD2, 3);
        int GCD3 = getGCD(3,6);
        assertNotEquals(GCD3, 2);
        int GCD4 = getGCD(8,-12);
        assertEquals(GCD4, -4);
    }

    @Test (expected = ArithmeticException.class) // Tests the first constructor will return an ArithmeticException when provided with a zero denominator value.
    public void testFraction1(){
        Fraction frac1 = new FractionImpl(1,0);
    }
    @Test (expected = NumberFormatException.class) // Tests the third constructor will return an ArithmeticException when provided with too many numeric values.
    public void testFraction3() {
        Fraction frac3 = new FractionImpl( "1 0 / -4" );
    }
    @Test
    public void testFraction4() {
        FractionImpl frac4;
        assertDoesNotThrow((Executable) (frac4 = new FractionImpl("10 / -4")));
    }
}
