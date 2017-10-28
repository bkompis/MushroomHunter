package cz.muni.fi.pa165.mushrooms.dao;


import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.enums.MushroomType;
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

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author bencikpeter
 */
@ContextConfiguration(classes= PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MushroomDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private MushroomDao mushroomDao;

    @PersistenceContext
    private EntityManager em;



    private Mushroom mushroom1;
    private Mushroom mushroom2;

    @Before
    public void setUp(){
        // create mushrooms
        mushroom1 = createMushroom("toadstool", MushroomType.POISONOUS,"June","July");
        mushroom2 = createMushroom("champignon", MushroomType.EDIBLE,"May","September");

        // persist mushrooms
        em.getTransaction().begin();
        em.persist(mushroom1);
        em.persist(mushroom2);
        em.getTransaction().commit();
    }

    private static Mushroom createMushroom(String name, MushroomType type, String beginMonth,String endMonth){
        Mushroom mushroom = new Mushroom();
        mushroom.setName(name);
        mushroom.setType(type);
        mushroom.setIntervalOfOccurence(beginMonth,endMonth);
        return mushroom;
    }

    @Test
    public void findById_validId() throws Exception {
        Mushroom mushroom = mushroomDao.findById(mushroom1.getId());
        assertThat(mushroom).isNotNull();
        assertThat(mushroom).isEqualToComparingFieldByField(mushroom1);
    }

    @Test
    public void findById_invalidId() throws Exception {
        Mushroom mushroom = mushroomDao.findById(mushroom1.getId()+20);
        assertThat(mushroom).isNull();
    }

    @Test
    public void create() throws Exception {
        Mushroom mushroom = createMushroom("WierdMushroom", MushroomType.UNEDIBLE, "May", "July");
        mushroomDao.create(mushroom);

        em.getTransaction().begin();
        Mushroom mush = em.find(Mushroom.class,em.contains(mushroom)? mushroom : em.merge(mushroom));
        em.getTransaction().commit();

        assertThat(mush).isEqualToComparingFieldByField(mushroom);

    }

    @Test
    public void delete() throws Exception {

        mushroomDao.delete(mushroom1);

        em.getTransaction().begin();
        List<Mushroom> list  = em.createQuery("select m from Mushroom m", Mushroom.class).getResultList();
        em.getTransaction().commit();

        assertThat(list).hasSize(1);

    }

    @Test
    public void findAll() throws Exception {

        List<Mushroom> list = mushroomDao.findAll();

        assertThat(list).hasSize(2);
    }

    @Test
    public void findByName_validName() throws Exception {

        Mushroom mushroom = mushroomDao.findByName(mushroom1.getName());
        assertThat(mushroom).isNotNull();
        assertThat(mushroom).isEqualToComparingFieldByField(mushroom1);
    }

    @Test
    public void findByName_invalidName() throws Exception {

        Mushroom mushroom = mushroomDao.findByName("randomName");
        assertThat(mushroom).isNull();
    }

}
