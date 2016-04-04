/**
 * This class is a representation of a rational number
 * @author  Roman Smirnov 312914443
 * @version 0.1
 * @since   2016-03-25
 */
public class Rational {
    // instance variables
    private int _denominator;
    private int _numerator;
    
    /**
     * The main constructor for the rational class
     *@param numerator  The numertor of the rational number
     *@param denominator The denominator of the rational number
     */
    public Rational(int numerator,int denominator) {
        // If the denominator isn't valid, set to zero
        if(denominator<=0){
            _numerator = 0;
            _denominator = 1;
        }else{
            _numerator = numerator;
            _denominator =denominator;
        }
    }
    
    /**
     * Getter for the numerator
     * @return  int The numerator
     */
    public int getNumerator(){

        return _numerator;
    }
    
    /**
     * Get function of denominator paramater.
     * @return double The denominator
     */
    public int getDenominator(){

        return _denominator;
    }
    
    /**
     * Check if one rational number is greater than another
     * @param other another rational number object
     * @return boolean True if this number is larger than other, False otherwise
     */
    public boolean greaterThan(Rational other) {
        if (_numerator * other.getDenominator() > other.getNumerator() * _denominator){
            return true;
        }
        return false;
    }
    
    /**
     *  Check if one rational number is equal to another
     * @param other another rational number object
     * @return boolean True if this number is equal to other, False otherwise
     * ---------------------------------------------------------------------------
     *
     */
    public boolean equals(Rational other) {
        if (this.getNumerator() * other.getDenominator() == other.getNumerator() * this.getDenominator()){
            return true;
        }
        return false;
    }
     
    /**
     * Add this rational number to another one
     * @param other    another rational number object
     * @return         a rational object which is the result of the addition
     */
    public Rational plus(Rational other) {
        int numerator = (this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator());
        int denominator = other.getDenominator() * this.getDenominator();
        
        return new Rational(numerator, denominator);
    }
    
     /**
     * Subtract this rational number to another one
     * @param other    another rational number object
     * @return         a rational object which is the result of the subtraction
     */
    public Rational minus(Rational other)
    {
        int numerator = (this.getNumerator() * other.getDenominator()) - (other.getNumerator() * this.getDenominator());
        int denominator = other.getDenominator() * this.getDenominator();
      
        return new Rational(numerator, denominator);
    }

    /**
     * Multiply this rational number by another one
     * @param other    another rational number object
     * @return         a rational object which is the result of the addition
     */
    public Rational multiply (Rational other){
        int numerator = this.getNumerator() * other.getNumerator();
        int denominator = other.getDenominator() * this.getDenominator();
        
        return new Rational(numerator, denominator);
    }

    /**
     * create a string representation of the rational number
     * @return      The string version of the rational number.
     */
    public String toString (){
        return this.getNumerator() + "/" + this.getDenominator();
    }
    
    /**
     * Reduce the rationl number to its lowest terms
     * @return  The rational number, reduced to lowest terms
     */
    public Rational reduceToLowestTerms(){
        int greatestCommonFactor = gcd(_numerator,_denominator);

        // if there's no common divisor
        if (greatestCommonFactor == -1){
            return this;
        }
        return new Rational(_numerator / greatestCommonFactor,_denominator / greatestCommonFactor);
    }
    
    /**
     * returns the greatest common divisor (factor) of the two numbers
     * @param   x   first number
     * @param   y   second number
     * @return      the greatest common divisor
     */
    private int gcd(int x,int y){
        if (y == 0){
            return x;
        }
        return gcd(y, x%y);
    }
}
