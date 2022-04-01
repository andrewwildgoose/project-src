package fraction;

import java.util.Arrays;
import java.util.List;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */

    private int numerator;
    private int denominator;

    public FractionImpl(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0){
            throw new ArithmeticException("divide by zero");
        }
        this.normalise(numerator, denominator);
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) throws NumberFormatException, ArithmeticException {
        String str = fraction.replaceAll("[^-?0-9]+", " "); // replaces all non numeric characters (and "-" signs) in the string with a space.
        List<String> nums = Arrays.asList(str.trim().split(" ")); // splits the new numeric string to a List

        if (nums.size() > 2) { // throws an exception if too many numbers have been found.
            throw new NumberFormatException("too many numbers");
        }
        if (nums.size() == 2) {// create a normalised fraction
            int numerator = Integer.parseInt(nums.get(0));
            int denominator = Integer.parseInt(nums.get(1));
            if (denominator == 0){
                throw new ArithmeticException("divide by zero");
            }
            this.normalise(numerator, denominator);
        }
        if (nums.size() == 1) { // create fraction with denominator of 1 if a whole number has been received
            this.numerator = Integer.parseInt(nums.get(0));
            this.denominator = 1;
        }

    }

    // method used to find the greatest common divisor which will be used to normalise the fraction.
    private static int getGCD(int numerator, int denominator){
        if (denominator==0) return Math.abs(numerator);
        return getGCD(denominator,numerator%denominator);
    }

    // method used to normalise fractions in the first and third constructors
    private void normalise(int numerator, int denominator){
        int GCD = getGCD(numerator, denominator);

        if (denominator < 0){
            this.numerator = numerator/(GCD*-1);
            this.denominator = denominator/(GCD*-1);
        }
        else{
            this.numerator = numerator/GCD;
            this.denominator = denominator/GCD;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        FractionImpl addMe = new FractionImpl(f.toString());

        int a = this.numerator; int b = this.denominator;
        int c = addMe.numerator; int d = addMe.denominator;

        return new FractionImpl((a*d + b*c), b*d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl takeMe = new FractionImpl(f.toString());

        int a = this.numerator; int b = this.denominator;
        int c = takeMe.numerator; int d = takeMe.denominator;

        return new FractionImpl((a*d - b*c), b*d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl multMe = new FractionImpl(f.toString());

        int a = this.numerator; int b = this.denominator;
        int c = multMe.numerator; int d = multMe.denominator;

        return new FractionImpl((a*c),(b*d));
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        FractionImpl divMe = new FractionImpl(f.toString());

        int a = this.numerator; int b = this.denominator;
        int c = divMe.numerator; int d = divMe.denominator;

        return new FractionImpl((a*d),(b*c));
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return new FractionImpl(Math.abs(this.numerator), Math.abs(this.denominator));
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        int numerator = this.numerator * -1;
        int denominator = this.denominator;
        return new FractionImpl(numerator,denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        boolean answer = false;
        if (obj instanceof Fraction f){
            answer = super.equals(f);
        }
        return answer;
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return new FractionImpl(this.denominator, this.numerator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        String numeratorStr = String.valueOf(numerator);
        String denominatorStr = String.valueOf(denominator);

        if (this.denominator == 1){
            return numeratorStr;
        }
        else if (this.numerator == 0){
            return numeratorStr + "0/1";
        }
        else {
            return numeratorStr + "/" + denominatorStr;
        }
    }

//    public static void main(String[] args) {
//        Fraction multFrac3 = new FractionImpl(-1,2);
//        Fraction multFrac4 = new FractionImpl(1,2);
//        Fraction multResult2 = multFrac3.multiply(multFrac4);
//        System.out.println(multResult2.toString());
//    }
}