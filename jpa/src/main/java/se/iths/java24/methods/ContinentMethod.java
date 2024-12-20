package se.iths.java24.methods;

import se.iths.java24.repository.ContinentRepository;

import java.util.Scanner;

import static se.iths.java24.Main.printAction;
import static se.iths.java24.repository.ContinentRepository.*;
import static se.iths.java24.repository.ContinentRepository.DeleteContinent;

public class ContinentMethod {

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
            scanner.nextLine();

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
}
