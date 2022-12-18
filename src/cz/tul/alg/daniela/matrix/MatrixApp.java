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

            Matrix m2Rotated = m2.deepCopy();

            boolean foundRotation = false;
            int rotation = 0;
            while (rotation < 360) {
                m2Rotated.rotate(rotation);
                if (Matrix.hasSameContent(m1,m2Rotated)) {
                    System.out.println("Rotace " + rotation);
                    foundRotation = true;
                }

                rotation += 90;
            }
            if (!foundRotation)
                System.out.println("Není rotací");
            // Run separator
            System.out.println();
        }

    }
}
