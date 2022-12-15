package cz.tul.alg.daniela.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    void basicTurnCases(Matrix a) {
        System.out.println("Print A matrix");
        a.print();

        Matrix ninetyDegrees = a.turn(90);
        System.out.println("\nPrint A matrix - turned 90 degrees");
        ninetyDegrees.print();

        Matrix oneHundredEightyDegrees = a.turn(180);
        System.out.println("\nPrint A matrix - turned 180 degrees");
        oneHundredEightyDegrees.print();

        Matrix twoHundredSeventyDegrees = a.turn(270);
        System.out.println("\nPrint A matrix - turned 270 degrees");
        twoHundredSeventyDegrees.print();
        assertAll(
                () -> assertTrue(Matrix.isSame(
                        a.turn(90), ninetyDegrees
                )),
                () -> assertTrue(Matrix.isSame(
                        ninetyDegrees.turn(180), twoHundredSeventyDegrees
                )),
                () -> assertTrue(Matrix.isSame(
                        oneHundredEightyDegrees.turn(90), twoHundredSeventyDegrees
                )),
                () -> assertTrue(Matrix.isSame(
                        twoHundredSeventyDegrees.turn(90), a
                )),
                () -> assertTrue(Matrix.isSame(
                        oneHundredEightyDegrees.turn(180), a
                ))
        );
    }
    @Test
    @DisplayName("Matrix isSame")
    void isSameTest() {
        // Testing cases - even
        Matrix a = new Matrix(4);
        Matrix b = new Matrix(4);
        a.fillRandomValues(-1_000, 1_000);

        // Copy primitive values
        b.data = a.data;

        // Assertion
        assertTrue(Matrix.isSame(a,b));

        // Testing cases - odd
        Matrix c = new Matrix(5);
        Matrix d = new Matrix(5);
        c.fillRandomValues(-1_000, 1_000);

        // Copy primitive values
        d.data = c.data;

        // Assertion
        assertTrue(Matrix.isSame(a,b));
    }
    @Test
    @DisplayName("Matrix turn method - edge cases")
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
    void turnEvenSizes() {
        // Testing cases
        Matrix a = new Matrix(2);
        a.fillRandomValues(-1_000, 1_000);
        basicTurnCases(a);

        Matrix b = new Matrix(4);
        b.fillRandomValues(-1_000, 1_000);
        basicTurnCases(b);
    }
}