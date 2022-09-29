package concrete_matrix;

import concrete_GenericMatrix.GenericMatrix;

public class IntegerMatrix extends GenericMatrix<Integer> {
    @Override
    protected Integer add(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    protected Integer multiply(Integer num1, Integer num2) {
        return num1 * num2;
    }

    @Override
    protected Integer zero() {
        return 0;
    }
}
