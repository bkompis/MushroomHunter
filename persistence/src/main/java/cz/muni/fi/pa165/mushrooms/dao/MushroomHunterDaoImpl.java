package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Buvko
 */
@Repository
public class MushroomHunterDaoImpl implements MushroomHunterDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MushroomHunter findById(Long id) {
        return em.find(MushroomHunter.class, id);
    }

    @Override
    public List<MushroomHunter> findAll() {
        return em.createQuery("select c from MushroomHunter c", MushroomHunter.class)
                .getResultList();
    }

    @Override
    public void create(MushroomHunter c) {
        if (c == null) {
            throw new IllegalArgumentException("Null mushroom hunter at create.");
        }
        em.persist(c);
    }

    @Override
    public void delete(MushroomHunter c) {
        em.remove(em.contains(c) ? c : em.merge(c));
    }

    @Override
    public void update(MushroomHunter c) {
        if (c == null) {
            throw new IllegalArgumentException("Null mushroom hunter at update.");
        }
        em.merge(c);
    }

    @Override
    public List<MushroomHunter> findByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName is null");
        }

        try {
            return em
                    .createQuery("select c from MushroomHunter c where c.firstName = :firstName",
                            MushroomHunter.class).setParameter("firstName", firstName)
                    .getResultList();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public List<MushroomHunter> findBySurname(String surname) {
        if (surname == null) {
            throw new IllegalArgumentException("surname is null");
        }
        try {
            return em
                    .createQuery("select c from MushroomHunter c where c.surname = :surname",
                            MushroomHunter.class).setParameter("surname", surname)
                    .getResultList();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public List<MushroomHunter> findByNickame(String userNickname) {
        if (userNickname == null) {
            throw new IllegalArgumentException("user nickname is null");
        }
        try {
            return em.createQuery("select c from MushroomHunter c where c.userNickname like :userNickname", MushroomHunter.class)
                    .setParameter("userNickname", "%" + userNickname + "%").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}