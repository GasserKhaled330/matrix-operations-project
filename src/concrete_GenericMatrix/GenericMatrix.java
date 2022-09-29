package concrete_GenericMatrix;

public abstract class GenericMatrix<T> {

    /**
     * Abstract method for adding two elements of the matrices
     */
    protected abstract T add(T obj1, T obj2);

    /**
     * Abstract method for multiplying two elements of the matrices
     */
    protected abstract T multiply(T obj1, T obj2);

    /**
     * Abstract method for defining zero for the matrix element
     */
    protected abstract T zero();

    /**
     * Add two matrices
     */
    public T[][] addMatrix(T[][] matrix1, T[][] matrix2) {
        // Check bounds of the two matrices
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
            throw new RuntimeException("The matrices do not have the same size");
        }

        try {
            T[][] result = (T[][]) new Object[matrix1.length][matrix1[0].length];
            // Perform addition
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = add(matrix1[i][j], matrix2[i][j]);
                }
            }
            return result;
        } catch (ClassCastException e) {
            System.out.println("can't cast to Generic Type");
        }
        return null;
    }

    /**
     * Multiply two matrices
     */
    public T[][] multiplyMatrix(T[][] matrix1, T[][] matrix2) {
        // Check bounds
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("The matrices do not have compatible size");
        }
        try {
        // Create result matrix
        T[][] result = (T[][]) new Object[matrix1.length][matrix2[0].length];

        // Perform multiplication of two matrices
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();

                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }

        return result;
        } catch (ClassCastException e) {
            System.out.println("can't cast Object matrix to Generic Type");
        }
        return null;
    }

    /**
     * Print matrices, the operator, and their operation result
     */
    public static void printResult(Object[][] m1, Object[][] m2, Object[][] m3, char op) {
        for (int i = 0; i < m1.length; i++) {
            // print first matrix
            for (int j = 0; j < m1[0].length; j++)
                System.out.print(" " + m1[i][j]);
            // print operator within two spaces
            if (i == m1.length / 2) System.out.print("  " + op + " ");
            else System.out.print("    ");

            //print second matrix
            for (int j = 0; j < m2.length; j++)
                System.out.print(" " + m2[i][j]);
            // print equal
            if (i == m1.length / 2) {
                System.out.print("  = ");
            }
            else System.out.print("    ");

            // print result matrix
            for (int j = 0; j < m3.length; j++)
                System.out.print(m3[i][j] + " ");

            System.out.println();
        }
    }
}

