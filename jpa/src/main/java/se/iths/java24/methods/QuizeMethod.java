package se.iths.java24.methods;

import java.util.Scanner;

import static se.iths.java24.Main.printAction;

public class QuizeMethod {

    public static void Quiz() {
        System.out.println("Startar quiz...");
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
                "What should be the Capital of Sweden?\n1. Stockholm\n2. Gothenburg\n3. Malmö",
                "What country in Europe is the biggest?\n1. Russia\n2. Ukraine\n3. France",
                "What continent is Australia part of?\n1. Asia\n2. Africa\n3. Oceania"
        };

        int[] correctAnswers = {2, 1, 3};
        int score = 0;

        System.out.println("Welcome to our Quiz! Answer with 1, 2, 3, or type 0 to go back.");

        for (int i = 0; i < questions.length; i++) {
            int answer = -1; // Initiera med ett ogiltigt svar
            while (answer < 0 || answer > 3) { // Loop tills användaren ger ett giltigt svar
                System.out.println(questions[i]);
                System.out.print("Your answer: ");
                try {
                    answer = scanner.nextInt();
                    if (answer < 0 || answer > 3) {
                        System.out.println("\nYou may only answer with 1, 2, 3 or 0!\n");
                    }
                } catch (Exception e) {
                    System.out.println("\nPlease enter a valid number (1, 2, 3, or 0)!\n");
                    scanner.next(); // Rensa felaktig inmatning
                }
            }

            if (answer == 0) {
                System.out.println("Returning to the main menu...");
                printAction();
                return; // Avsluta quizet
            }

            if (answer == correctAnswers[i]) {
                System.out.println("Rätt!\n");
                score++;
            } else {
                System.out.println("Wrong. The correct answer is " + correctAnswers[i] + ".\n");
            }
        }

        System.out.println("Du fick " + score + " av " + questions.length + " rätt!");

        printAction(); // Gå tillbaka till huvudmenyn efter quiz!
    }
}
