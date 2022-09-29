package concrete;

public class Complex implements Cloneable, Comparable<Complex> {
    private final double a;
    private final double b;

    // Constructors
    /** Creates a complex object for number 0 */
    public Complex() {
        this(0, 0);
    }

    /** Create a complex object with 0 for b */
    public Complex(double a) {
        this(a, 0);
    }

    /** Creates a complex object with specified a and b */
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }



    public double getRealPart() {
        return a;
    }


    public double getImaginaryPart() {
        return b;
    }


    public Complex add(Complex secondComplex) {
        return new Complex(a + secondComplex.a,
                b + secondComplex.b);
    }


    public Complex subtract(Complex secondComplex) {
        return new Complex(a - secondComplex.a,
                b - secondComplex.b);
    }


    public Complex multiply(Complex secondComplex) {
        return new Complex(a * secondComplex.a - b * secondComplex.b,
                b * secondComplex.a + a * secondComplex.b);
    }


    public Complex divide(Complex secondComplex) {
        double denominator = Math.pow(secondComplex.a, 2) + Math.pow(secondComplex.b, 2);
        return new Complex((a * secondComplex.a + b * secondComplex.b) /
                denominator,
                (b * secondComplex.a - a * secondComplex.b) /
                        denominator);
    }


    public double abs(Complex complex) {
        return Math.sqrt(Math.pow(complex.a, 2) + Math.pow(complex.b, 2));
    }

    @Override
    public Complex clone() throws CloneNotSupportedException {
        return (Complex)super.clone();
    }

    @Override
    public String toString() {
        return b == 0 ? a + "" : "(" + a + " + " + b + "i)";
    }

    @Override
    public int compareTo(Complex o) {
        return Double.compare(abs(this), abs(o));
    }
}
