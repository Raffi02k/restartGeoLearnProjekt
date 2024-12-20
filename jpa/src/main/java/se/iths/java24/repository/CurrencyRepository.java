package se.iths.java24.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import se.iths.java24.JPAUtil;
import se.iths.java24.entity.Country;
import se.iths.java24.entity.Currency;

import java.util.List;
import java.util.Scanner;

import static se.iths.java24.JPAUtil.getEntityManager;
import static se.iths.java24.JPAUtil.inTransaction;

public class CurrencyRepository {

    public static Currency findCurrencyByCountryCode(String countryCode) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c WHERE c.country.countryCode = :code", Currency.class);
        query.setParameter("code", countryCode);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    public static void createCurrency() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter currency code:");
        String code = scanner.nextLine();
        System.out.println("Enter currency name:");
        String name = scanner.nextLine();
        System.out.println("Enter country code:");
        String countryCode = scanner.nextLine();

        EntityManager em = getEntityManager();
        Country country = em.find(Country.class, countryCode);

        if (country != null) {
            Currency currency = new Currency();
            currency.setCurrencyCode(code);
            currency.setCurrencyName(name);
            currency.setCountryCode(country);

            inTransaction(em1 -> em1.persist(currency));

            System.out.println("Currency created successfully.");
        } else {
            System.out.println("Country not found.");
        }
    }

    public static void updateCurrency() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the currency code of the currency you want to update:");
        String code = scanner.nextLine();
        System.out.println("Enter the new name for the currency:");
        String newName = scanner.nextLine();

        inTransaction(em -> {
            Currency currency = em.find(Currency.class, code);
            if (currency != null) {
                currency.setCurrencyName(newName);
                System.out.println("Currency updated successfully.");
            } else {
                System.out.println("Currency not found.");
            }
        });
    }

    public static void deleteCurrency() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the currency code of the currency you want to delete:");
        String code = scanner.nextLine();

        inTransaction(em -> {
            Currency currency = em.find(Currency.class, code);
            if (currency != null) {
                em.remove(currency);
                System.out.println("Currency deleted successfully.");
            } else {
                System.out.println("Currency not found.");
            }
        });
    }

    public static void showCurrencies() {
        EntityManager em = getEntityManager();
        TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c", Currency.class);
        List<Currency> currencies = query.getResultList();

        if (currencies.isEmpty()) {
            System.out.println("No currencies found.");
        } else {
            currencies.forEach(System.out::println);
        }

        em.close();
    }
}
