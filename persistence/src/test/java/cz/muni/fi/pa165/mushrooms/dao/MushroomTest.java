package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import cz.muni.fi.pa165.mushrooms.validation.PersistenceSampleApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Buvko on 22.10.2017.
 */
@ContextConfiguration(classes= PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MushroomTest  extends AbstractTestNGSpringContextTests {

    @Autowired
    private MushroomHunterDao mushroomHunterDao;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void createPrice(){
        MushroomHunter mushroomHunter = new MushroomHunter();
        mushroomHunter.setFirstName("Matt");
        mushroomHunter.setSurname("Patt");

        mushroomHunterDao.create(mushroomHunter);

        List<MushroomHunter> categories  = mushroomHunterDao.findAll();

        Assert.assertEquals(categories.size(), 1);
    }
}
