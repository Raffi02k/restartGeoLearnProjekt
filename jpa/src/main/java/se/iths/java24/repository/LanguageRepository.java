package se.iths.java24.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import se.iths.java24.JPAUtil;
import se.iths.java24.entity.Country;
import se.iths.java24.entity.Language;

import java.util.List;
import java.util.Scanner;

import static se.iths.java24.JPAUtil.getEntityManager;
import static se.iths.java24.JPAUtil.inTransaction;

public class LanguageRepository {

    public static Language findLanguageByCountryCode(String countryCode) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Language> query = em.createQuery("SELECT l FROM Language l WHERE l.country.countryCode = :code", Language.class);
        query.setParameter("code", countryCode);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    public static void createLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter language name:");
        String name = scanner.nextLine();
        System.out.println("Enter country code:");
        String countryCode = scanner.nextLine();

        EntityManager em = getEntityManager();
        Country country = em.find(Country.class, countryCode);

        if (country != null) {
            Language language = new Language();
            language.setLanguageName(name);
            language.setCountryCode(country);

            inTransaction(em1 -> em1.persist(language));

            System.out.println("Language created successfully.");
        } else {
            System.out.println("Country not found.");
        }
    }

    public static void updateLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the language you want to update:");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter the new name for the language:");
        String newName = scanner.nextLine();

        inTransaction(em -> {
            Language language = em.find(Language.class, id);
            if (language != null) {
                language.setLanguageName(newName);
                System.out.println("Language updated successfully.");
            } else {
                System.out.println("Language not found.");
            }
        });
    }

    public static void deleteLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the language you want to delete:");
        Long id = scanner.nextLong();

        inTransaction(em -> {
            Language language = em.find(Language.class, id);
            if (language != null) {
                em.remove(language);
                System.out.println("Language deleted successfully.");
            } else {
                System.out.println("Language not found.");
            }
        });
    }

    public static void showLanguages() {
        EntityManager em = getEntityManager();
        TypedQuery<Language> query = em.createQuery("SELECT l FROM Language l", Language.class);
        List<Language> languages = query.getResultList();

        if (languages.isEmpty()) {
            System.out.println("No languages found.");
        } else {
            languages.forEach(System.out::println);
        }

        em.close();
    }
}
