package cz.tul.alg.daniela.christmas;
import java.util.Scanner;

public class VanoceDanielAdamek {
    /* Usage of C-like Pair object for easy range editing */
    private static final PairDanielAdamek<Integer> snowmanRange = new PairDanielAdamek<>(1, 4);
    private static final PairDanielAdamek<Integer> densityRange = new PairDanielAdamek<>(0, 100);
    /* Other static values */
    private static final String FULL = "█";
    private static final char EMPTY = ' ';
    private static final String SNOW = "❄️";

    public static void printSnowflake(int x, int density) {
        if (x % (100-density) == 0) System.out.print(SNOW);
        else System.out.print(EMPTY);
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int numberOfBalls = 0, snowDensity = 0;

        /* Load input data */

        do {
            System.out.print("Enter number of balls (range: <" + snowmanRange.first + ";" + snowmanRange.second + ">): ");
            numberOfBalls = sc.nextByte();
            if (numberOfBalls < snowmanRange.first || numberOfBalls > snowmanRange.second) System.out.println("Number is out of range!");
        } while (numberOfBalls < snowmanRange.first || numberOfBalls > snowmanRange.second);
        do {
            System.out.print("Enter number snow density (range: <" + densityRange.first + ";" + densityRange.second + ">; best: <96:98>): ");
            snowDensity = sc.nextByte();
            if (snowDensity < densityRange.first || snowDensity > densityRange.second) System.out.println("Number is out of range!");
        } while (snowDensity < densityRange.first || snowDensity > densityRange.second);

        /* Space between enter values and art */
        System.out.print("\n\n\n\n\n");

        /* Declaration of required variables */
        int WIDE = numberOfBalls*20;
        double dist;
        int radius = 1;

        // Draw balls
        for (int cnt = 0; cnt < numberOfBalls; cnt++) {
            // Draw height
            for (int i = 0; i <= 2 * radius; i++) {
                // Draw empty
                for (int j = 0; j <= (WIDE/2)-radius; j++) printSnowflake(2*j+i, snowDensity);
                // Draw circle
                for (int j = 0; j <= 2 * radius; j++) {
                    dist = Math.sqrt((i - radius) * (i - radius) + (j - radius) * (j - radius));
                    if (dist < radius + 0.4) {
                        // Print dots
                        if (j == radius
                            && i > 1 && i < 2*radius-1
                            && i % 3 == 0) System.out.print('◆');
                        else System.out.print(FULL);

                    }
                    else
                        printSnowflake(j+i, snowDensity);
                }
                // Draw empty
                for (int j = 0; j <= (WIDE/2)-radius; j++) printSnowflake(j+i, snowDensity);
                System.out.print("\n");
            }
            radius += 2;
        }

    }

}
