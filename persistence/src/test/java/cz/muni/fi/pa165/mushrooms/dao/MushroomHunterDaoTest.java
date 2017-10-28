package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import cz.muni.fi.pa165.mushrooms.validation.PersistenceSampleApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import static org.assertj.core.api.Assertions.*;

/**
 * @author bkompis
 */
@ContextConfiguration(classes= PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MushroomHunterDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private MushroomHunterDao mushroomHunterDao;

    @PersistenceContext
    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory emf;

    private MushroomHunter hunter1;
    private MushroomHunter hunter2;

    @Before
    public void setUp(){
        // create hunters
        hunter1 = createMushroomHunter("John", "Doe");
        hunter2 = createMushroomHunter("Jack", "Daniels");

        // persist hunters
        EntityManager m = emf.createEntityManager();
        m.getTransaction().begin();
        em.persist(hunter1);
        em.persist(hunter2);
        m.getTransaction().commit();
        m.close();
    }

    private static MushroomHunter createMushroomHunter(String firstName, String surname){
        MushroomHunter hunter = new MushroomHunter();
        hunter.setFirstName(firstName);
        hunter.setSurname(surname);
        hunter.setPersonalInfo("The mushroom hunter " + firstName + " " + surname);
        return hunter;
    }

    @Test
    public void findById_validId() throws Exception {
        MushroomHunter hunter = mushroomHunterDao.findById(hunter1.getId());
        assertThat(hunter).isNotNull();
        assertThat(hunter).isEqualToComparingFieldByField(hunter1);
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findByFirstName() throws Exception {
    }

    @Test
    public void findBySurname() throws Exception {
    }

}