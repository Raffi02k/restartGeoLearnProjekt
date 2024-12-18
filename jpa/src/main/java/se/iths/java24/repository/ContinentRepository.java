package se.iths.java24.repository;

import jakarta.persistence.EntityManager;
import se.iths.java24.JPAUtil;
import se.iths.java24.entity.Continent;
import se.iths.java24.entity.Country;

import java.util.Optional;

public class ContinentRepository {
    public Optional<Continent> continentWithName(String countryName) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return Optional.of(em.createQuery("select c from Continent c where c.continentName = :continentName", Continent.class)
                    .setParameter("continentName", countryName)
                    .getSingleResult());
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

}
