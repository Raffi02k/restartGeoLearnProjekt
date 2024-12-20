package se.iths.java24.methods;

import se.iths.java24.repository.CurrencyRepository;

import java.util.Scanner;

public class CurrencyMethod {

    public static void currencyMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCurrency Menu:");
        System.out.println("1. Show Currencies");
        System.out.println("2. Create a Currency");
        System.out.println("3. Update a Currency");
        System.out.println("4. Delete a Currency");
        System.out.println("5. Back to CRUD Menu");
        System.out.print("Choose an option: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CurrencyRepository.showCurrencies();
                    currencyMenu();
                    break;
                case 2:
                    CurrencyRepository.createCurrency();
                    break;
                case 3:
                    CurrencyRepository.updateCurrency();
                    break;
                case 4:
                    CurrencyRepository.deleteCurrency();
                    break;
                case 5:
                    return; // Tillbaka till CRUD-menyn
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } else {
            System.out.println("Invalid input, please enter a number.");
            scanner.next();
        }
    }
}
