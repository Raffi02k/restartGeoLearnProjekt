package se.iths.java24;

import java.util.Scanner;

import static se.iths.java24.methods.CityMethod.population;
import static se.iths.java24.methods.ContinentMethod.continentMenu;
import static se.iths.java24.methods.QuizeMethod.Quiz;
import static se.iths.java24.methods.StatisticMethod.statistic;


public class Main {

    public static void main(String[] args) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        printAction();

        while (!quit) {
            System.out.print("Ange ditt val (1-5): ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        continentMenu();
                        break;
                    case 2:
                        population();
                        break;
                    case 3:
                        statistic();
                        break;
                    case 4:
                        Quiz();
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Avslutar programmet. Tack!");
                        break;
                    default:
                        System.out.println("Ogiltigt val, försök igen. Välj ett nummer mellan 1 och 5.");
                        printAction();
                }
            } else {
                System.out.println("Ogiltig inmatning! Ange ett nummer mellan 1 och 5.");
                printAction();
                scanner.next(); // Rensar felaktig inmatning
            }
        }

        scanner.close();
    }

    public static void printAction() {
        System.out.println("""
                
                Welcome to Geo Learn Projekt!
                Välj:
                1.  - Continent.
                2.  - Population.
                3.  - Statistic.
                4.  - Quiz!
                5.  - Quit.
                """);
    }
}
