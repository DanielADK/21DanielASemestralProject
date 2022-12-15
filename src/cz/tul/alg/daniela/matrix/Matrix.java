package cz.tul.alg.daniela.matrix;

/**
 * A matrix is a 2D array of integers
 */
public class Matrix {
    // A variable that stores the size of the matrix.
    public int size;
    // Creating a 2D array of integers - stored data.
    public int[][] data;

    /**
     * Constructor of square matrix
     * @param size - size of matrix
     */
    Matrix(int size) {
        this.size = size;
        this.data = new int[size][size];
    }

    /**
     * If the sizes of the two matrices are not the same, return false. Otherwise, for each element in the matrices, if the
     * elements are not the same, return false. Otherwise, return true.
     *
     * @param a The first matrix to compare.
     * @param b The matrix to compare to a.
     * @return The method is returning a boolean value.
     */
    public static boolean isSame(Matrix a, Matrix b) {
        if (a.size != b.size) return false;
        for (int i = 0; i < a.size; i++) {
            for (int j = 0; j < a.size; j++) {
                if (a.data[i][j] != b.data[i][j]) return false;
            }
        }
        return true;
    }

    /**
     * > Transpose the matrix, then reverse the columns
     *
     * @param degrees the number of degrees to rotate the matrix by.
     * @return A new matrix with the same data as the original matrix, but rotated by the specified number of degrees.
     */
    public Matrix turn(int degrees) {
        // Checks if degrees is 0, 90, 180 or 270
        if (degrees%90 != 0 || degrees > 270 || degrees < 0) return null;

        Matrix newMatrix = new Matrix(this.size);
        newMatrix.data = this.data;

        // Rotate by 90 degrees -> 180-degree rotation = 2x 90-degree rotation.
        for (int i = 0; i < degrees/90; i++) {
            // Transposition and copy to new matrix
            int tmp;
            for (int y = 0; y < this.size; y++) {
                for (int x = 0; x < this.size; x++) {
                    tmp = newMatrix.data[y][x];
                    newMatrix.data[y][x] = newMatrix.data[x][y];
                    newMatrix.data[x][y] = tmp;
                }
            }

            // Reversing columns
            int[] tmpCol;
            for (int y = 0; y < this.size/2; y++) {
                tmpCol = newMatrix.data[y];
                newMatrix.data[y] = newMatrix.data[this.size-y-1];
                newMatrix.data[this.size-y-1] = tmpCol;
            }
        }
        return newMatrix;
    }
    /**
     * This function prints the matrix
     */
    public void print() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }}
    /**
     * This function fills the matrix with random values between min and max.
     *
     * @param min the minimum value of the random numbers
     * @param max The maximum value that can be generated.
     */
    public void fillRandomValues(int min, int max) {
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                this.data[i][j] = (int) (Math.random() * (max - min));
    }
}
