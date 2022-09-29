package test_classes;

import concrete.Complex;
import concrete_GenericMatrix.GenericMatrix;
import concrete_matrix.ComplexMatrix;

public class TestComplexMatrix {
    public static void main(String[] args) {
        Complex[][] m1 = new Complex[3][3];
        Complex[][] m2 = new Complex[3][3];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m1[i][j] = new Complex(i + 0.5, j + 0.5);
                m2[i][j] = new Complex( -(i + 1), j);
            }
        }
        ComplexMatrix complexMatrix = new ComplexMatrix();

        System.out.println("\nm1 + m2 is ");
        GenericMatrix.printResult(m1, m2, complexMatrix.addMatrix(m1, m2), '+');

        System.out.println("\nm1 * m2 is ");

        GenericMatrix.printResult(m1, m2, complexMatrix.multiplyMatrix(m1, m2), '*');
    }
}
