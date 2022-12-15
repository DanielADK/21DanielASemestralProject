package cz.tul.alg.daniela.matrix;

import java.util.Scanner;

/**
 * It reads a matrix from the console, and it reads a rotation from the console
 */
public class UserInterface {
    // It creates a new scanner object, which is used to read from the console.
    public static Scanner sc = new Scanner(System.in);
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
    /**
     * It reads a line from the console, splits it by space, checks if the first word is "Rotace" and if the second word is
     * a number, and if so, it returns the number
     *
     * @return The rotation in degrees.
     */
    public static int readRotation() {
        String str = sc.next();
        // Split by space to get degrees
        String[] split = str.split(" ");
        // The second string has to be a number - count of degrees
        if (!split[0].equals("Rotace")) {
            System.out.println("Neznámá operace!");
            return -1;
        }
        int rotation = Integer.parseInt(split[1]);

        // If rotation is not 90, 180 or 270 - return -1 as error, otherwise the degrees
        return (rotation == 90 ||
                rotation == 180 ||
                rotation == 270) ? rotation : -1;
    }
}
