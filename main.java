import java.util.Scanner;

/**
 * A program to store and perform operations on rational numbers
 * @author Roman Smirnov 312914443
 * @version 0.1
 * @since 2016-03-25
 */
public class main {
    private static final int NUMERATOR = 0;
    private static final int DENOMINATOR = 1;

    // get two rational numbers and perform a showcase of all the methods from the Rational class
    public static void main(String[] args) {
        int numerator;
        int denominator;
        Rational firstRationalNum;
        Rational secondRationalNum;

        // get the first rational number from user
        System.out.println("enter a rational number:");
        numerator = getNum(NUMERATOR);
        denominator = getNum(DENOMINATOR);
        firstRationalNum = new Rational(numerator, denominator);

        // get the second rational number from user
        System.out.println("enter a second rational number:");
        numerator = getNum(NUMERATOR);
        denominator = getNum(DENOMINATOR);
        secondRationalNum = new Rational(numerator, denominator);

        // showcase all the method in the Rational class
        if (firstRationalNum.equals(secondRationalNum)) {
            System.out.println("The numbers are equal");
        } else {
            System.out.print("The larger number is ");
            if (firstRationalNum.greaterThan(secondRationalNum)) {
                System.out.println(firstRationalNum.toString());
            } else {
                System.out.println(secondRationalNum.toString());
            }
        }
        // go down a line
        System.out.println("");


        System.out.println("adding the numbers gives us " + firstRationalNum.plus(secondRationalNum).toString());
        System.out.println("subtracting the numbers gives us " + firstRationalNum.minus(secondRationalNum).toString());
        System.out.println("multiplying the numbers gives us " + firstRationalNum.multiply(secondRationalNum).toString());
        System.out.println("The rational number " + firstRationalNum.toString() + " is reduced to " + firstRationalNum.reduceToLowestTerms().toString());
        System.out.println("The rational number " + secondRationalNum.toString() + " is reduced to " + secondRationalNum.reduceToLowestTerms().toString());
    }

    /**
     * This method gets a number input from the user and validates it
     *
     * @param dataType         A string corresponding to the input data type (i.e denominator or numerator)
     * @return                 The int number from the user
     */
    private static int getNum(int dataType) {
        Scanner scan = new Scanner(System.in);
        int num=0;
        boolean valid = false;

        while(valid == false) {
            // check if the input is an int
            while (!scan.hasNextInt()){
                System.out.println("you number is invalid. please try again");
                scan.next();
                continue;
            }
            num=scan.nextInt();
            // if it's a denominator, check that it's positive
            if(dataType==DENOMINATOR && num<=0){
                System.out.println("the denominator can't be less than, or equal to,  zero. Try again");
                scan.next();
            }else{
                valid = true;
            }
        }
        return num;
    }
}