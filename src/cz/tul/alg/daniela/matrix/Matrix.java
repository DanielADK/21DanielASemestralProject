package cz.tul.alg.daniela.matrix;

public class Matrix {
    public int size;
    public int[][] data;

    Matrix(int size) {
        this.size = size;
        this.data = new int[size][size];
    }

    public static boolean isSame(Matrix a, Matrix b) {
        if (a.size != b.size) return false;
        for (int i = 0; i < a.size; i++) {
            for (int j = 0; j < a.size; j++) {
                if (a.data[i][j] != b.data[i][j]) return false;
            }
        }
        return true;
    }

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
    public void print() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }}
    public void fillRandomValues(int min, int max) {
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                this.data[i][j] = (int) (Math.random() * (max - min));
    }
}
