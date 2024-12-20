package se.iths.java24.methods;

import se.iths.java24.repository.LanguageRepository;

import java.util.Scanner;

public class LanguageMethod {

    public static void languageMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nLanguage Menu:");
        System.out.println("1. Show Languages");
        System.out.println("2. Create a Language");
        System.out.println("3. Update a Language");
        System.out.println("4. Delete a Language");
        System.out.println("5. Back to CRUD Menu");
        System.out.print("Choose an option: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LanguageRepository.showLanguages();
                    languageMenu();
                    break;
                case 2:
                    LanguageRepository.createLanguage();
                    break;
                case 3:
                    LanguageRepository.updateLanguage();
                    break;
                case 4:
                    LanguageRepository.deleteLanguage();
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
