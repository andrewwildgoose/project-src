// 13717321
// awildg01@student.bbk.ac.uk

package fraction;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionImplTest {

    @Test (expected = ArithmeticException.class) // Tests the first constructor will return an ArithmeticException when provided with a zero denominator value.
    public void testFraction1(){
        Fraction const1Frac1 = new FractionImpl(1,0);
    }
    @Test (expected = NumberFormatException.class) // Tests the third constructor will return an ArithmeticException when provided with too many numeric values.
    public void testFraction2() {
        Fraction const3Frac1 = new FractionImpl( "1 0 / -4" );
    }
    @Test (expected = ArithmeticException.class) // Tests the first constructor will return an ArithmeticException when provided with a zero denominator value.
    public void testFraction3(){
        Fraction const3Frac2 = new FractionImpl("5/0");
    }

    // Tests for the toString method, the different constructors, the normalise and the GCD methods.

    @Test
    public void testToString1(){ // Testing the first constructor with a simple fraction
        Fraction toStringFrac1 = new FractionImpl(1,2);
        assertEquals(toStringFrac1.toString(), "1/2");
    }
    @Test
    public void testToString2() { // Testing the first constructor to check it provides the normalised fraction
        Fraction toStringFrac2 = new FractionImpl(8, -12);
        assertEquals(toStringFrac2.toString(), "-2/3");
    }
    @Test
    public void testToString3() { // Testing the second constructor
        Fraction toStringFrac3 = new FractionImpl(2);
        assertEquals(toStringFrac3.toString(), "2");
    }
    @Test
    public void testToString4() { // Testing the second constructor with a 2-digit number
        Fraction toStringFrac4 = new FractionImpl(10);
        assertEquals(toStringFrac4.toString(), "10");
    }
    @Test
    public void testToString5() { // Testing the third constructor with a non-whole number
        Fraction toStringFrac6 = new FractionImpl("5/2");
        assertEquals(toStringFrac6.toString(), "5/2");
    }
    @Test
    public void testToString6() { // Testing the third constructor with a whole number
        Fraction toStringFrac6 = new FractionImpl("5");
        assertEquals(toStringFrac6.toString(), "5");
    }
    @Test
    public void testToString7() { // Testing the third constructor with a fraction that requires normalising
        Fraction toStringFrac7 = new FractionImpl("5/10");
        assertEquals(toStringFrac7.toString(), "1/2");
    }
    @Test
    public void testToString8() { // Testing the third constructor with a fraction that results in 0
        Fraction toStringFrac8 = new FractionImpl("0/5");
        assertEquals(toStringFrac8.toString(), "0");
    }
    @Test
    public void testToString9() { // Testing the second constructor with a fraction that results in 0
        Fraction toStringFrac9 = new FractionImpl(0);
        assertEquals(toStringFrac9.toString(), "0");
    }

    // Tests for the add method

    @Test
    public void testAdd1(){ // Testing simple fraction addition with the same denominators
        Fraction addFrac1 = new FractionImpl(2,4);
        Fraction addFrac2 = new FractionImpl(1,4);
        Fraction addResult1 = addFrac1.add(addFrac2);
        assertEquals(addResult1.toString(), "3/4");
    }
    @Test
    public void testAdd2(){ // Testing fraction addition with the different denominators
        Fraction addFrac3 = new FractionImpl(1,2);
        Fraction addFrac4 = new FractionImpl(1,4);
        Fraction addResult2 = addFrac3.add(addFrac4);
        assertEquals(addResult2.toString(), "3/4");
    }
    @Test
    public void testAdd3(){ // Testing fraction addition that totals at the whole number 1
        Fraction addFrac5 = new FractionImpl(1,2);
        Fraction addFrac6 = new FractionImpl(2,4);
        Fraction addResult3 = addFrac5.add(addFrac6);
        assertEquals(addResult3.toString(), "1");
    }
    @Test
    public void testAdd4(){ // Testing fraction addition that totals at the whole number 2
        Fraction addFrac7 = new FractionImpl(2,2);
        Fraction addFrac8 = new FractionImpl(4,4);
        Fraction addResult4 = addFrac7.add(addFrac8);
        assertEquals(addResult4.toString(), "2");
    }
    @Test
    public void testAdd5(){ // Testing fraction addition with the whole number constructor
        Fraction addFrac7 = new FractionImpl(2);
        Fraction addFrac8 = new FractionImpl(4);
        Fraction addResult4 = addFrac7.add(addFrac8);
        assertEquals(addResult4.toString(), "6");
    }
    @Test
    public void testAdd6(){ // Testing fraction addition with the string constructor
        Fraction addFrac9 = new FractionImpl("1/2");
        Fraction addFrac10 = new FractionImpl("1/4");
        Fraction addResult5 = addFrac9.add(addFrac10);
        assertEquals(addResult5.toString(), "3/4");
    }

    // Tests for the subtract method

    @Test
    public void testSubtract1(){ // Testing simple fraction subtraction with the same denominators
        Fraction subFrac1 = new FractionImpl(2,4);
        Fraction subFrac2 = new FractionImpl(1,4);
        Fraction subResult1 = subFrac1.subtract(subFrac2);
        assertEquals(subResult1.toString(), "1/4");
    }
    @Test
    public void testSubtract2(){ // Testing fraction subtraction with the different denominators
        Fraction subFrac3 = new FractionImpl(1,2);
        Fraction subFrac4 = new FractionImpl(1,4);
        Fraction subResult2 = subFrac3.subtract(subFrac4);
        assertEquals(subResult2.toString(), "1/4");
    }
    @Test
    public void testSubtract3(){ // Testing fraction subtraction that totals at the whole number 1
        Fraction subFrac5 = new FractionImpl(6,4);
        Fraction subFrac6 = new FractionImpl(1,2);
        Fraction subResult3 = subFrac5.subtract(subFrac6);
        assertEquals(subResult3.toString(), "1");
    }
    @Test
    public void testSubtract4(){ // Testing fraction subtraction that totals at the negative whole number -1
        Fraction subFrac7 = new FractionImpl(1,2);
        Fraction subFrac8 = new FractionImpl(6,4);
        Fraction subResult4 = subFrac7.subtract(subFrac8);
        assertEquals(subResult4.toString(), "-1");
    }

    // Tests for multiply method

    @Test
    public void testMultiply1(){ // Testing simple fraction multiplication
        Fraction multFrac1 = new FractionImpl(1,2);
        Fraction multFrac2 = new FractionImpl(1,2);
        Fraction multResult1 = multFrac1.multiply(multFrac2);
        assertEquals(multResult1.toString(), "1/4");
    }
    @Test
    public void testMultiply2(){ // Testing fraction multiplication containing negative numerator
        Fraction multFrac3 = new FractionImpl(-1,2);
        Fraction multFrac4 = new FractionImpl(1,2);
        Fraction multResult2 = multFrac3.multiply(multFrac4);
        assertEquals(multResult2.toString(), "-1/4");
    }
    @Test
    public void testMultiply3(){ // Testing fraction multiplication containing negative denominator
        Fraction multFrac5 = new FractionImpl(1,-2);
        Fraction multFrac6 = new FractionImpl(1,2);
        Fraction multResult3 = multFrac5.multiply(multFrac6);
        assertEquals(multResult3.toString(), "-1/4");
    }
    @Test
    public void testMultiply4(){ // Testing fraction multiplication containing negative numerator and denominator
        Fraction multFrac7 = new FractionImpl(-1,-2);
        Fraction multFrac8 = new FractionImpl(1,2);
        Fraction multResult4 = multFrac7.multiply(multFrac8);
        assertEquals(multResult4.toString(), "1/4");
    }

    // Tests for divide method

    @Test
    public void testDivide1() { // Testing simple fraction division
        Fraction divFrac1 = new FractionImpl(1, 2);
        Fraction divFrac2 = new FractionImpl(1, 2);
        Fraction divResult1 = divFrac1.divide(divFrac2);
        assertEquals(divResult1.toString(), "1");
    }
    @Test
    public void testDivide2() { // Testing fraction division with different denominator
        Fraction divFrac3 = new FractionImpl(1, 2);
        Fraction divFrac4 = new FractionImpl(1, 4);
        Fraction divResult2 = divFrac3.divide(divFrac4);
        assertEquals(divResult2.toString(), "2");
    }
    @Test
    public void testDivide3() { // Testing fraction division that results in a non-whole number
        Fraction divFrac5 = new FractionImpl(1, 2);
        Fraction divFrac6 = new FractionImpl(4, 6);
        Fraction divResult3 = divFrac5.divide(divFrac6);
        assertEquals(divResult3.toString(), "3/4");
    }
    @Test
    public void testDivide4() { // Testing fraction division that results in a non-whole number with a negative numerator
        Fraction divFrac7 = new FractionImpl(-1, 2);
        Fraction divFrac8 = new FractionImpl(4, 6);
        Fraction divResult4 = divFrac7.divide(divFrac8);
        assertEquals(divResult4.toString(), "-3/4");
    }
    @Test
    public void testDivide5() { // Testing fraction division with a negative denominator that results in a non-whole number
        Fraction divFrac9 = new FractionImpl(1, -2);
        Fraction divFrac10 = new FractionImpl(4, 6);
        Fraction divResult5 = divFrac9.divide(divFrac10);
        assertEquals(divResult5.toString(), "-3/4");
    }
    @Test
    public void testDivide6() { // Testing fraction division with a negative denominator that results in a negative whole number
        Fraction divFrac11 = new FractionImpl(1, -2);
        Fraction divFrac12 = new FractionImpl(1, 2);
        Fraction divResult6 = divFrac11.divide(divFrac12);
        assertEquals(divResult6.toString(), "-1");
    }

    // Tests for abs method

    @Test
    public void testAbs1() { // Testing fraction absolute value with a negative denominator
        Fraction absFrac1 = new FractionImpl(1, -2);
        assertEquals(absFrac1.abs().toString(), "1/2");
    }
    @Test
    public void testAbs2() { // Testing fraction absolute value with a negative numerator
        Fraction absFrac2 = new FractionImpl(-1, 2);
        assertEquals(absFrac2.abs().toString(), "1/2");
    }
    @Test
    public void testAbs3() { // Testing fraction absolute value with a negative numerator that requires normalisation
        Fraction absFrac3 = new FractionImpl(-2, 4);
        assertEquals(absFrac3.abs().toString(), "1/2");
    }
    @Test
    public void testAbs4() { // Testing fraction absolute value with a negative numerator and denominator that requires normalisation
        Fraction absFrac4 = new FractionImpl(-2, -4);
        assertEquals(absFrac4.abs().toString(), "1/2");
    }

    // Tests for negate method

    @Test
    public void testNegate1() { // Testing simple fraction negation
        Fraction negFrac1 = new FractionImpl(1, 2);
        assertEquals(negFrac1.negate().toString(), "-1/2");
    }
    @Test
    public void testNegate2() { // Testing fraction negation starting with a negative fraction
        Fraction negFrac2 = new FractionImpl(-1, 2);
        assertEquals(negFrac2.negate().toString(), "1/2");
    }
    @Test
    public void testNegate3() { // Testing fraction negation starting with a negative fraction
        Fraction negFrac3 = new FractionImpl(-1, -2);
        assertEquals(negFrac3.negate().toString(), "-1/2");
    }
    @Test
    public void testNegate4() { // Testing fraction negation starting with a negative denominator
        Fraction negFrac4 = new FractionImpl(1, -2);
        assertEquals(negFrac4.negate().toString(), "1/2");
    }

    // Tests for inverse method

    @Test
    public void testInverse1() { // Testing simple fraction inversion
        Fraction invFrac1 = new FractionImpl(3, 4);
        assertEquals(invFrac1.inverse().toString(), "4/3");
    }
    @Test
    public void testInverse2() { // Testing fraction inversion that returns a whole number
        Fraction invFrac2 = new FractionImpl(1, 2);
        assertEquals(invFrac2.inverse().toString(), "2");
    }
    @Test
    public void testInverse3() { // Testing fraction inversion that returns a negative whole number
        Fraction invFrac3 = new FractionImpl(-1, 2);
        assertEquals(invFrac3.inverse().toString(), "-2");
    }

    // Tests for equals method

    @Test
    public void testEquals1() { // Testing simple fraction equality
        Fraction eqlFrac1 = new FractionImpl(3, 4);
        Fraction eqlFrac2 = new FractionImpl(3, 4);
        assertTrue(eqlFrac1.equals(eqlFrac2));
    }
    @Test
    public void testEquals2() { // Testing simple fraction inequality
        Fraction eqlFrac3 = new FractionImpl(3, 4);
        Fraction eqlFrac4 = new FractionImpl(1, 2);
        assertFalse(eqlFrac3.equals(eqlFrac4));
    }
    @Test
    public void testEquals3() { // Testing simple fraction inequality with negative fraction
        Fraction eqlFrac5 = new FractionImpl(3, 4);
        Fraction eqlFrac6 = new FractionImpl(-3, 4);
        assertFalse(eqlFrac5.equals(eqlFrac6));
    }
    @Test
    public void testEquals4() { // Testing simple fraction inequality with non fraction object
        Fraction eqlFrac7 = new FractionImpl(3, 4);
        int notFrac = 1;
        assertFalse(eqlFrac7.equals(notFrac));
    }

    // Tests for compareTo method

    @Test
    public void testCompareTo1() { // Testing fraction comparison resulting in equality
        Fraction compFrac1 = new FractionImpl(3, 4);
        Fraction compFrac2 = new FractionImpl(3, 4);
        assertEquals(compFrac1.compareTo(compFrac2), 0);
    }
    @Test
    public void testCompareTo2() { // Testing fraction comparison resulting in greater
        Fraction compFrac3 = new FractionImpl(3, 4);
        Fraction compFrac4 = new FractionImpl(1, 2);
        assertEquals(compFrac3.compareTo(compFrac4), 1);
    }
    @Test
    public void testCompareTo3() { // Testing fraction comparison resulting in lesser
        Fraction compFrac5 = new FractionImpl(1, 2);
        Fraction compFrac6 = new FractionImpl(3, 4);
        assertEquals(compFrac5.compareTo(compFrac6), -1);
    }
    @Test
    public void testCompareTo4() { // Testing fraction comparison resulting in greater due to negative comparator
        Fraction compFrac7 = new FractionImpl(1, 2);
        Fraction compFrac8 = new FractionImpl(-3, 4);
        assertEquals(compFrac7.compareTo(compFrac8), 1);
    }
}