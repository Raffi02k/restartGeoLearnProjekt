package se.iths.java24;

import jakarta.persistence.EntityManager;

import java.util.Optional;

public class CountryRepository {

    public Optional<Country> countryWithName(String countryName) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return Optional.of(em.createQuery("select c from Country c where c.countryName = :countryName", Country.class)
                            .setParameter("countryName", countryName)
                    .getSingleResult());
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }
}
