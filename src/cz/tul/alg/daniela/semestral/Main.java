package cz.tul.alg.daniela.semestral;

import cz.tul.alg.daniela.christmas.*;
import cz.tul.alg.daniela.matrix.MatrixApp;
import cz.tul.alg.daniela.matrix.UserInterface;

/**
 * 21. Program checks if first matrix is turn variation of the second one.
 *
 * @author daniel.adamek
 * @version 1.0 14-12-2022
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    """
                    /===================================================\\
                        Zadejte číslo programu, který chcete spustit:
                        1. vánoční úloha,
                        2. semestrální práce (číslo 21),
                        3. ukončení programu.
                    \\===================================================/
                    """
            );
            int program = UserInterface.sc.nextInt();
            switch (program) {
                case 1 -> VanoceDanielAdamek.run();
                case 2 -> MatrixApp.run();
                case 3 -> { return; }
                default -> System.out.println("Neznámá volba.");
            }
        }
    }
}