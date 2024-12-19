package se.iths.java24;

import se.iths.java24.repository.ContinentRepository;

import java.util.Scanner;

import static se.iths.java24.repository.ContinentRepository.*;

public class Main {

    public static void main(String[] args) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in); // Glöm inte att skapa en scanner-instans

        printAction();

        while (!quit) {
            System.out.print("Ange ditt val (1-5): ");

            // Kontrollera om inmatningen är en siffra
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Konsumera newline-karaktären
                switch (choice) {
                    case 1:
                        continentMenu();
                        break;
                    case 2:
                        population();
                        break;
                    case 3:
                        statistik();
                        break;
                    case 4:
                        Quiz();
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Avslutar programmet. Tack!");
                        break;
                    default:
                        System.out.println("Ogiltigt val, försök igen. Välj ett nummer mellan 1 och 6.");
                        printAction();
                }
            } else {
                System.out.println("Ogiltig inmatning! Ange ett nummer mellan 1 och 6.");
                scanner.next(); // Rensar felaktig inmatning
            }
        }

        scanner.close(); // Glöm inte att stänga scannern
    }

    public static void continentMenu() {
        Scanner scanner = new Scanner(System.in);
        ContinentRepository repository = new ContinentRepository();

        System.out.println("\nContinent Menu:");
        System.out.println("1. Show Continents");
        System.out.println("2. Create a Continent");
        System.out.println("3. Update a Continent");
        System.out.println("4. Delete a Continent");
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose an option: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumera newline-karaktären

            switch (choice) {
                case 1:
                    showContinents();
                    continentMenu();
                    break;
                case 2:
                    CreateContinent();
                    break;
                case 3:
                    UpdateContinent();
                    break;
                case 4:
                    DeleteContinent();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    printAction();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } else {
            System.out.println("Invalid input, please enter a number.");
            scanner.next();
        }
    }

    public static void countriesEurope() {
        System.out.println("Visar länder i Europa...");
        // Lägg till relevant logik här
    }

    public static void population() {
        System.out.println("Visar befolkningsdata...");
        // Lägg till relevant logik här
    }

    public static void statistik() {
        System.out.println("Visar statistik...");
        // Lägg till relevant logik här
    }

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
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();

            if (answer == correctAnswers[i]) {
                System.out.println("Rätt!\n");
                score++;
            }
            if (answer == 0) {
                System.out.println("Returning to the main menu...");
                printAction();
                return;
            }
            else {
                System.out.println("Wrong. The correct answer is " + correctAnswers[i] + ".\n");
            }
        }

        System.out.println("Du fick " + score + " av " + questions.length + " rätt!");

        printAction();
    }

    public static void printAction() {
        System.out.println("""
                
                Welcome to Geo Learn Projekt!
                Välj:
                1.  - Continent.
                2.  - Population.
                3.  - Statistik.
                4.  - Quiz!
                5.  - Quit.
                """);
    }
}
