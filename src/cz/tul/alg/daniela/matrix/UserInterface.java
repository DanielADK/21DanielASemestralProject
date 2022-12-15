package cz.tul.alg.daniela.matrix;

import java.util.Scanner;

/**
 * It reads a matrix from the console, and it reads a rotation from the console
 */
public class UserInterface {
    // It creates a new scanner object, which is used to read from the console.
    public static Scanner sc = new Scanner(System.in);
    /**
     * If the next input is an integer, read it and return it, otherwise return -1.
     *
     * @return The size of the array.
     */
    public static int readSize() {
        if (!sc.hasNext()) return -1;
        int size = sc.nextInt();
        return (size > 0) ? size : -1;
    }
    /**
     * It reads a matrix from the input stream, and returns it if it's valid, or null if it's not
     *
     * @param size the size of the matrix to be read
     * @return A matrix object
     */
    public static Matrix readMatrix(int size) {
        Matrix newMatrix = new Matrix(size);

        int insertCounter = 0;
        for (int i = 0; i < size && sc.hasNext(); i++) {
            for (int j = 0; j < size && sc.hasNext(); j++) {
                newMatrix.data[i][j] = sc.nextInt();
                insertCounter++;
            }
        }
        // It checks if the matrix is valid, and if it is, it returns it, otherwise it returns null.
        return (insertCounter == size*size)? newMatrix : null;
    }
}
