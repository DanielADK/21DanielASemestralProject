package cz.tul.alg.daniela.matrix;

/**
 * The type Matrix app.
 */
public class MatrixApp {
    /**
     * Runs matrix-rotation-identifier application while input size is not 0 or less than zero
     */
    public static void run() {
        while (true) {
            System.out.println("Rozměr matic");
            int size = UserInterface.readSize();
            // If size is -1, then exit the program
            if (size == -1) return;

            // Load matrix data from user
            System.out.println("První matice");
            Matrix m1 = UserInterface.readMatrix(size);

            System.out.println("Druhá matice");
            Matrix m2 = UserInterface.readMatrix(size);

            if (m1 == null || m2 == null) {
                System.out.println("Jedna z matic byla špatně načtena. Zadejte matice ještě jednou.\n");
                continue;
            }

            int[] rotationsMem = new int[4];

            // rotation of matrix
            Matrix m2Rotated = m2.deepCopy();
            int rotation = 0;
            while (rotation < 360) {
                if (Matrix.hasSameContent(m1,m2Rotated))
                    rotationsMem[rotation/90] = rotation;

                m2Rotated.rotate(90);
                rotation += 90;
            }

            boolean rotated = false;
            for (int r:rotationsMem) {
                if (r != 0)  {
                    System.out.println("Rotace " + r);
                    rotated = true;
                }
            }
            if (!rotated) System.out.println("Není rotací");

            // Run separator
            System.out.println();
        }

    }

    /**
     * Standalone run without menu
     */
    public static void main(String[] args) {
        run();
    }
}
