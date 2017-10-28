package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import cz.muni.fi.pa165.mushrooms.validation.PersistenceSampleApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests for the MushroomHunterDao with prepopulated database.
 *
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

    private MushroomHunter hunter1;
    private MushroomHunter hunter2;

    @Before
    public void setUp(){
        // create hunters
        hunter1 = createMushroomHunter("John", "Doe", "Johny");
        hunter2 = createMushroomHunter("Jack", "Daniels", "Dan");

        // persist hunters
        em.persist(hunter1);
        em.persist(hunter2);
    }

    private static MushroomHunter createMushroomHunter(String firstName, String surname, String userNickname){
        MushroomHunter hunter = new MushroomHunter();
        hunter.setFirstName(firstName);
        hunter.setSurname(surname);
        hunter.setUserNickname(userNickname);
        hunter.setPersonalInfo("The mushroom hunter "+ userNickname + " - " + firstName + " " + surname);
        return hunter;
    }

    @Test
    public void findById_validId() throws Exception {
        MushroomHunter hunter = mushroomHunterDao.findById(hunter1.getId());
        assertThat(hunter).isNotNull();
        assertThat(hunter).isEqualToComparingFieldByField(hunter1);
        assertThat(hunter).isEqualTo(hunter1);
    }

    @Test
    public void findById_nullId() throws Exception {
        assertThatThrownBy(() -> mushroomHunterDao.findById(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void findById_nonexistentId() throws Exception {
        Long nonexistentId = hunter1.getId() + hunter2.getId();
        assertThat(mushroomHunterDao.findById(nonexistentId)).isNull();
    }

    @Test
    public void findAll() throws Exception {
        assertThat(mushroomHunterDao.findAll()).containsExactlyInAnyOrder(hunter1, hunter2);
    }

    @Test
    public void findByFirstName_validName() throws Exception {
        List<MushroomHunter> found = mushroomHunterDao.findByFirstName("John");
        assertThat(found).containsExactly(hunter1);
    }

    @Test
    public void findByFirstName_unknownName() throws Exception {
        List<MushroomHunter> found = mushroomHunterDao.findByFirstName("Nonexistent");
        assertThat(found).isEmpty(); // or null?
    }
    @Test
    public void findByFirstName_nullName() throws Exception {
        assertThatThrownBy(() -> mushroomHunterDao.findByFirstName(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void findBySurname_validName() throws Exception {
        List<MushroomHunter> found = mushroomHunterDao.findBySurname("Doe");
        assertThat(found).containsExactly(hunter1);
    }

    @Test
    public void findBySurname_unknownName() throws Exception {
        List<MushroomHunter> found = mushroomHunterDao.findBySurname("Nonexistent");
        assertThat(found).isEmpty(); // or null?
    }

    @Test
    public void findBySurname_nullName() throws Exception {
        assertThatThrownBy(() -> mushroomHunterDao.findBySurname(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void create_valid() throws Exception {
        MushroomHunter newHunter = createMushroomHunter("Sylvanas", "Windrunner");
        mushroomHunterDao.create(newHunter);
        assertThat(newHunter.getId()).isNotNull();
        assertThat(newHunter.getId()).isNotEqualTo(0); // necessary?

        //compare the the newly created entity with the one stored in the database
        assertThat(newHunter).isEqualToComparingFieldByField(mushroomHunterDao.findById(newHunter.getId()));
    }


    @Test
    public void create_entityHasDuplicateId() throws Exception {
        // todo: no setId() method
    }

    @Test
    public void create_duplicateEntity() throws Exception{
        //todo: needs proper unique constraints
/*        try{
            mushroomHunterDao.create(hunter1);
        } catch (Exception e) {
            System.err.println(e);
        }*/
        //assertThatThrownBy(() -> mushroomHunterDao.create(hunter1)).isInstanceOf(JpaSystemException.class);
    }

    @Test
    public void create_entityAlreadySaved() throws Exception {
        //TODO: need proper unique constraints
        /*MushroomHunter newHunter = createMushroomHunter(hunter1.getFirstName(), hunter1.getSurname());
        assertThatThrownBy(() -> mushroomHunterDao.create(newHunter)).isInstanceOf(JpaSystemException.class);*/
    }
//TODO: null names (create, update, delete)
//TODO: tests for update

    @Test
    public void delete() throws Exception {
    }

}