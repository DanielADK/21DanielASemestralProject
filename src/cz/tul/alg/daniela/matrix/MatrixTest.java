package cz.tul.alg.daniela.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    /**
     * It validates the matrix, turns it 90, 180, and 270 degrees, and print the matrices
     *
     * @param a the matrix to be turned
     */
    void basicTurnCases(Matrix a) {
        Matrix tmp;

        System.out.println("Print A matrix");
        a.print();

        Matrix ninetyDegrees = a.deepCopy();
        ninetyDegrees.rotate(90);
        System.out.println("\nPrint A matrix - turned 90 degrees");
        ninetyDegrees.print();

        Matrix oneHundredEightyDegrees = a.deepCopy();
        oneHundredEightyDegrees.rotate(180);
        System.out.println("\nPrint A matrix - turned 180 degrees");
        oneHundredEightyDegrees.print();

        Matrix twoHundredSeventyDegrees = a.deepCopy();
        twoHundredSeventyDegrees.rotate(270);
        System.out.println("\nPrint A matrix - turned 270 degrees");
        twoHundredSeventyDegrees.print();

        // 90 + 180 -> 270
        tmp = ninetyDegrees.deepCopy();
        tmp.rotate(180);
        assertTrue(Matrix.hasSameContent(tmp, twoHundredSeventyDegrees));

        // 180 + 90 -> 270
        tmp = oneHundredEightyDegrees.deepCopy();
        tmp.rotate(90);
        assertTrue(Matrix.hasSameContent(tmp, twoHundredSeventyDegrees));

        Matrix threeHunderedSixty = a.deepCopy();
        ninetyDegrees.rotate(270);
        ninetyDegrees.rotate(90);
        System.out.println("\nPrint A matrix - turned 360 degrees");
        threeHunderedSixty.print();
        assertTrue(Matrix.hasSameContent(a,threeHunderedSixty));
    }

    @Test
    @DisplayName("Matrix data - deep copy of data")
    // Deep copy test
    void matrixRotationDataSameObject() {
        Matrix a = new Matrix(4);
        a.fillRandomValues(-1_000, 1_000);

        Matrix b = a.deepCopy();
        assertNotSame(a.data, b.data);

        a = b.deepCopy();
        assertNotSame(a.data, b.data);

    }
    @Test
    @DisplayName("Matrix isSame")
    // Testing if the method `isSame` is working correctly.
    void isSameTest() {
        // Testing cases - even
        Matrix a = new Matrix(4);
        Matrix b = new Matrix(4);
        a.fillRandomValues(-1_000, 1_000);

        // Copy primitive values
        b.data = a.data;

        // Assertion
        assertTrue(Matrix.hasSameContent(a,b));

        // Testing cases - odd
        Matrix c = new Matrix(5);
        Matrix d = new Matrix(5);
        c.fillRandomValues(-1_000, 1_000);

        // Copy primitive values
        d.data = c.data;

        // Assertion
        assertTrue(Matrix.hasSameContent(a,b));
    }
    @Test
    @DisplayName("Matrix turn method - edge cases")
    // Testing the edge cases of the turn method.
    void turnEdgeCases() {
        // Testing cases
        Matrix a = new Matrix(0);
        a.fillRandomValues(-1_000, 1_000);
        basicTurnCases(a);

        Matrix b = new Matrix(1);
        b.fillRandomValues(-1_000, 1_000);
        basicTurnCases(b);
    }
    @Test
    @DisplayName("Matrix turn method - Odd sizes")
    // A method that is testing the turn method for odd sizes.
    void turnOddSizes() {
        // Testing cases
        Matrix a = new Matrix(3);
        a.fillRandomValues(-1_000, 1_000);
        basicTurnCases(a);

        Matrix b = new Matrix(5);
        b.fillRandomValues(-1_000, 1_000);
        basicTurnCases(b);
    }
    @Test
    @DisplayName("Matrix turn method - Even sizes")
    // A method that is testing the turn method for even sizes.
    void turnEvenSizes() {
        // Testing cases
        Matrix a = new Matrix(2);
        a.fillRandomValues(-1_000, 1_000);
        basicTurnCases(a);

        Matrix b = new Matrix(4);
        b.fillRandomValues(-1_000, 1_000);
        basicTurnCases(b);
    }
    @Test
    @DisplayName("Matrix turn method - manual rotation")
    void manualRotation() {
        // Testing cases
        Matrix a = new Matrix(2);
        a.data = new int[][]{
            {1, 2},
            {3, 4}
        };
        a.rotate(90);
        a.print();

        Matrix ninetyDegrees = new Matrix(2);
        ninetyDegrees.data = new int[][]{
                {3, 1},
                {4, 2}
        };
        ninetyDegrees.print();
        assertTrue(Matrix.hasSameContent(a,ninetyDegrees));
    }
}