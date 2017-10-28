package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import cz.muni.fi.pa165.mushrooms.validation.PersistenceSampleApplicationContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the MushroomHunterDao with an empty database.
 *
 * @author bkompis
 */
@ContextConfiguration(classes= PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MushroomHunterDaoTestNoSetup {
    @Autowired
    private MushroomHunterDao mushroomHunterDao;

    @Test
    public void findById_nonexistentId() throws Exception {
        // the database contains no entries, and thus no ID's
        assertThat(mushroomHunterDao.findById(1L)).isNull();
    }

    @Test
    public void findAll_emptyDatabase() throws Exception {
        assertThat(mushroomHunterDao.findAll()).isEmpty(); //or null?
    }

    @Test
    public void findByFirstName_emptyDatabase() throws Exception {
        assertThat(mushroomHunterDao.findByFirstName("anything")).isEmpty(); // or null
    }

    @Test
    public void findBySurname() throws Exception {
        assertThat(mushroomHunterDao.findBySurname("anything")).isEmpty(); // or null

    }

    @Test
    public void create_entityHasId() throws Exception {
        MushroomHunter hunter = new MushroomHunter();
        hunter.setFirstName("John");
        hunter.setSurname("Doe");

    }
}
