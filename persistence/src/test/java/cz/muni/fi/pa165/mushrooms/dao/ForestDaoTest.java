package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.Forest;
import cz.muni.fi.pa165.mushrooms.validation.PersistenceSampleApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Buvko
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
public class ForestDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Inject
    private ForestDao forestDao;

    @PersistenceContext
    private EntityManager em;

    private Forest forest;
    private Forest forest2;

    @Before
    public void setUp() {
        forest = new Forest();
        forest.setName("Dun Morogh");
        forest.setDescription("Dun Morogh forest in South Wisconsin");

        forest2 = new Forest();
        forest2.setName("Sholazar Basin");
        forest2.setDescription("Sholazar Basin forest in Northrend");

        em.persist(forest);
        em.persist(forest2);
        em.flush();
    }

    @Test
    public void create_validForest() throws Exception {
        int sizeBeforeCreate = forestDao.findAll().size();
        Forest testForest = new Forest();
        testForest.setName("Duskwood");

        forestDao.create(testForest);
        Forest foundForest = em.find(Forest.class, testForest.getId());

        assertThat(foundForest).isNotNull();
        assertThat(forestDao.findAll().size()).isEqualTo(sizeBeforeCreate + 1);
        assertThat(forestDao.findAll()).containsExactlyInAnyOrder(forest, forest2, foundForest);
    }

    @Test
    public void create_nullForest() throws Exception {
        assertThatThrownBy(() -> forestDao.create(null)).hasRootCauseExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void create_ForestWithNullName() throws Exception {
        Forest testForest = new Forest();
        testForest.setName(null);

        assertThatThrownBy(() -> forestDao.create(testForest)).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    public void create_ForestWithNonUniqueName() throws Exception {
        Forest testForest = new Forest();
        testForest.setName(forest.getName());

        assertThatThrownBy(() -> forestDao.create(testForest)).isInstanceOf(JpaSystemException.class);
    }

    @Test
    public void create_ExistingForest() {
        int sizeBeforeCreate = forestDao.findAll().size();
        forestDao.create(forest);

        // Inserting same object will not raise the number of database entities
        assertThat(forestDao.findAll().size()).isEqualTo(sizeBeforeCreate);
    }

    @Test
    public void delete_validForest() throws Exception {
        int sizeBeforeCreate = forestDao.findAll().size();

        forestDao.delete(forest);
        em.flush();

        assertThat(forestDao.findAll().size()).isEqualTo(sizeBeforeCreate - 1);
        assertThat(forestDao.findAll()).containsExactlyInAnyOrder(forest2);
    }

    @Test
    public void delete_nullForest() throws Exception {
        assertThatThrownBy(() -> forestDao.delete(null)).hasRootCauseInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void delete_nonExistingForest() {
        int sizeBeforeCreate = forestDao.findAll().size();
        Forest testForest = new Forest();
        testForest.setName("Ashenvale");

        forestDao.delete(testForest);
        em.flush();

        assertThat(forestDao.findAll().size()).isEqualTo(sizeBeforeCreate);
        assertThat(forestDao.findAll()).containsExactlyInAnyOrder(forest, forest2);
    }

    @Test
    public void update_validForestName() {
        String newName = "Teldrassil";
        Forest foundForest = em.find(Forest.class, forest.getId());

        foundForest.setName(newName);
        forestDao.update(foundForest);
        em.flush();

        assertThat(em.find(Forest.class, forest.getId()).getName()).isEqualTo(newName);
    }

    @Test
    public void update_validForestDescription() {
        String newDescription = "Dun Morogh forest surrounded by Khaz Mountains";
        Forest foundForest = em.find(Forest.class, forest.getId());

        foundForest.setDescription(newDescription);
        forestDao.update(foundForest);
        em.flush();

        assertThat(em.find(Forest.class, forest.getId()).getDescription()).isEqualTo(newDescription);
    }

    @Test
    public void update_nullForest() {
        assertThatThrownBy(() -> forestDao.update(null)).hasRootCauseInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void update_ForestWithNullName() {
        Forest foundForest = forestDao.findById(forest.getId());
        foundForest.setName(null);
        assertThat(foundForest.getName()).isNull();
        forestDao.update(foundForest);
        assertThatThrownBy(() -> em.flush()).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    public void findAll_forests() throws Exception {
        assertThat(forestDao.findAll()).containsExactlyInAnyOrder(forest, forest2);
    }

    @Test
    public void findByName_withExistingForestName() throws Exception {
        String forestName = "Dun Morogh";
        Forest found = forestDao.findByName(forestName);
        assertThat(found).isNotNull();
        assertThat(found).isEqualTo(forest);
    }

    @Test
    public void findByName_withNonExistingForestName() {
        String forestName = "Terrokar forest";
        Forest found = forestDao.findByName(forestName);
        assertThat(found).isNull();
    }

    @Test
    public void findByName_nullForestName() throws Exception {
        assertThatThrownBy(() -> forestDao.findByName(null)).hasRootCauseInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void findById_validId() throws Exception {
        Forest testForest = forestDao.findById(forest.getId());
        assertThat(testForest).isNotNull();
        assertThat(testForest).isEqualTo(forest);
    }

    @Test
    public void findById_nullId() throws Exception {
        assertThatThrownBy(() -> forestDao.findById(null)).hasRootCauseExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void findById_invalidId() throws Exception {
        Long invalidID = new Long(64);
        Forest testForest = forestDao.findById(invalidID);
        assertThat(testForest).isNull();
    }


}
