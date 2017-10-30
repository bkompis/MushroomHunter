package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.Visit;
import cz.muni.fi.pa165.mushrooms.utils.LocalDateAttributeConverter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * @author bkompis
 */
@Repository
public class VisitDaoImpl implements VisitDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Visit visit) {
        if (visit == null) {
            throw new IllegalArgumentException("Null visit at create.");
        }
        em.persist(visit);
    }

    @Override
    public void delete(Visit visit) {
        em.remove(em.contains(visit) ? visit : em.merge(visit));
    }

    @Override
    public void update(Visit visit) {
        if (visit == null) {
            throw new IllegalArgumentException("Null visit at update.");
        }
        em.merge(visit);
    }

    @Override
    public Visit findById(Long id) {
        return em.find(Visit.class, id);
    }

    @Override
    public List<Visit> findAll() {
        return em.createQuery("select v from Visit v", Visit.class)
                .getResultList();
    }

    @Override
    public List<Visit> findByDate(LocalDate from, LocalDate to) {
        if (from == null) {
            throw new IllegalArgumentException("'from' date null");
        }
        if (to == null) {
            throw new IllegalArgumentException("'to' date null");
        }
        // convert input values to java.sql.Date
        LocalDateAttributeConverter converter = new LocalDateAttributeConverter();
        Date beginDate = converter.convertToDatabaseColumn(from);
        Date endDate = converter.convertToDatabaseColumn(to);

        try {
            // see https://stackoverflow.com/questions/957394/
            TypedQuery<Visit> query = em.createQuery(
                    "SELECT v FROM Visit v WHERE v.date BETWEEN :beginDate AND :endDate", Visit.class)
                    .setParameter("beginDate", beginDate, TemporalType.DATE)
                    .setParameter("endDate", endDate, TemporalType.DATE);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
