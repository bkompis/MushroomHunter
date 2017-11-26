package cz.muni.fi.pa165.mushrooms.service;

import cz.muni.fi.pa165.mushrooms.dao.VisitDao;
import cz.muni.fi.pa165.mushrooms.dto.ForestDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterDTO;
import cz.muni.fi.pa165.mushrooms.dto.VisitDTO;
import cz.muni.fi.pa165.mushrooms.entity.Forest;
import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import cz.muni.fi.pa165.mushrooms.entity.Visit;
import cz.muni.fi.pa165.mushrooms.enums.MushroomType;
import cz.muni.fi.pa165.mushrooms.utils.LocalDateAttributeConverter;
import mockit.Deencapsulation;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataAccessException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

/**
 * Extensive tests for service layer related to Visit entity.
 *
 * @author bkompis
 */
public class VisitServiceTest {
    @Injectable
    private VisitDao visitDao;

    @Tested(fullyInitialized = true)
    private VisitServiceImpl service;

    private MushroomHunter hunter1;
    private MushroomHunter hunter2;
    private Forest forest1;
    private Forest forest2;
    private Visit visit1;
    private Visit visit2; // maybe unnecessary
    private Mushroom mushroom1;
    private Mushroom mushroom2;

    private Map<Long, Visit> persistedVisits;
    // stores 'database' size
    private long dbCounter = 1;

    //TODO: move to TestUtils
    private static MushroomHunter createMushroomHunter(String firstName, String surname, String userNickname) {
        MushroomHunter hunter = new MushroomHunter();
        hunter.setFirstName(firstName);
        hunter.setSurname(surname);
        hunter.setUserNickname(userNickname);
        hunter.setPersonalInfo("Mushroom hunter " + userNickname + " - " + firstName + " " + surname);
        return hunter;
    }

    @Before
    public void setUp() {
        // note: for tests here, password hash and password are the same
        hunter1 = createMushroomHunter("Alphonse", "Elric", "theGoodGuy");
        hunter1.setPasswordHash("armor");
        hunter1.setId(1L);

        hunter2 = createMushroomHunter("Edward", "Elric", "fullmetal");
        hunter2.setPasswordHash("winry");
        hunter2.setId(2L);
        hunter2.setAdmin(true);

        forest1 = new Forest();
        forest1.setName("Listnaty");
        Deencapsulation.setField(forest1, "id", 1L);

        forest2 = new Forest();
        forest2.setName("Ihlicnaty");
        Deencapsulation.setField(forest2, "id", 2L);

        mushroom1 = new Mushroom();
        mushroom1.setName("Hrib Dubovy");
        mushroom1.setType(MushroomType.EDIBLE);
        mushroom1.setIntervalOfOccurrence("June", "July");
        mushroom1.setId(1L);

        mushroom2 = new Mushroom();
        mushroom2.setName("Hrib Satan");
        mushroom2.setType(MushroomType.POISONOUS);
        mushroom2.setIntervalOfOccurrence("July", "September");
        mushroom1.setId(2L);

        visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setHunter(hunter1);
        visit1.setForest(forest1);
        List<Mushroom> shrooms1 = new ArrayList<>();
        shrooms1.add(mushroom1);
        shrooms1.add(mushroom2);
        visit1.setMushrooms(shrooms1);
        visit1.setId(1L);

        visit2 = new Visit();
        visit2.setDate(LocalDate.now());
        visit2.setHunter(hunter2);
        visit2.setForest(forest2);
        List<Mushroom> shrooms2 = new ArrayList<>();
        shrooms2.add(mushroom1);
        visit2.setMushrooms(shrooms2);
        visit2.setId(2L);

        persistedVisits = new HashMap<>();
        persistedVisits.put(dbCounter, visit1);
        dbCounter++;
        persistedVisits.put(dbCounter, visit2);
        dbCounter++;

        new Expectations() {{
            visitDao.create((Visit) any);
            result = new Delegate() {
                void foo(Visit visit) {
                    if (visit == null) {
                        throw new IllegalArgumentException("null");
                    }
                    if (visit.getId() != null) {
                        throw new IllegalArgumentException("already in db");
                    }
                    if (visit.getDate() == null) {
                        throw new IllegalArgumentException("null date");
                    }
                    if (visit.getForest() == null) {
                        throw new IllegalArgumentException("null forest");
                    }
                    if (visit.getHunter() == null) {
                        throw new IllegalArgumentException("null hunter");
                    }
                    if (TestUtils.checkVisitDuplicity(persistedVisits, visit)) {
                        throw new IllegalArgumentException("duplicate");
                    }

                    visit.setId(dbCounter);
                    persistedVisits.put(dbCounter, visit);
                    dbCounter++;
                }
            };
            minTimes = 0;

            visitDao.delete((Visit) any);
            result = new Delegate() {
                void foo(Visit visit) {
                    if (visit == null || visit.getId() == null) {
                        throw new IllegalArgumentException("invalid entity");
                    }
                    if (persistedVisits.get(visit.getId()) == null) {
                        throw new IllegalArgumentException("not in db");
                    }
                    // TODO" other error cases
                    persistedVisits.remove(visit.getId());
                }
            };
            minTimes = 0;

            visitDao.update((Visit) any);
            result = new Delegate() {
                void foo(Visit visit) {
                    if (visit == null) {
                        throw new IllegalArgumentException("null entity");
                    }
                    if (visit.getId() == null) {
                        throw new IllegalArgumentException("null entity id");
                    }
                    if (TestUtils.checkVisitDuplicity(persistedVisits, visit)) {
                        throw new IllegalArgumentException("duplicate after update");
                    }
                    persistedVisits.replace(visit.getId(), visit);
                }
            };
            minTimes = 0;

            visitDao.findById((Long) any);
            result = new Delegate() {
                Visit foo(Long id) {
                    if (id == null) {
                        throw new IllegalArgumentException("null id");
                    }
                    return persistedVisits.get(id);
                }
            };
            minTimes = 0;

            visitDao.findAll();
            result = new Delegate() {
                List<Visit> foo() {
                    return Collections.unmodifiableList(new ArrayList<>(persistedVisits.values()));
                }
            };
            minTimes = 0;

            visitDao.findByDate((LocalDate) any, (LocalDate) any);
            result = new Delegate() {
                List<Visit> foo(LocalDate from, LocalDate to) {
                    if (from == null || to == null) {

                        throw new IllegalArgumentException("null date");
                    }
                    List<Visit> res = new ArrayList<>();
                    for (Visit v : persistedVisits.values()) {
                        if (v.getDate().isAfter(from) && v.getDate().isBefore(to)) {
                            res.add(v);
                        }
                    }
                    return res;
                }
            };
            minTimes = 0;

        }};
    }

    @Test
    public void findVisitById_valid() {
        assertThat(service.findVisitById(1L)).isEqualTo(visit1);
        assertThat(service.findVisitById(2L)).isEqualTo(visit2);
    }

    @Test
    public void findVisitById_unknownId() {
        assertThat(service.findVisitById(200L)).isEqualTo(null);
    }

    @Test
    public void findVisitById_nullId() {
        assertThatThrownBy(() -> service.findVisitById(null)).isInstanceOf(DataAccessException.class);
    }

    @Test
    public void findAllVisits() {
        assertThat(service.findAllVisits()).containsExactlyInAnyOrder(visit1, visit2);
    }

    @Test
    public void findVisitByDate() { //TODO
    }

    @Test
    public void createVisit_valid() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        Visit newVisit = TestUtils.createVisit(); //TODO
        service.createVisit(newVisit);
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2, newVisit);
    }

    @Test
    public void createVisit_nullVisit() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        assertThatThrownBy(() -> service.createVisit(null)).isInstanceOf(DataAccessException.class);
    }

    @Test
    public void createVisit_invalidVisit_nullForest() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        Visit newVisit = TestUtils.createVisit(); //TODO
        newVisit.setForest(null);
        assertThatThrownBy(() -> service.createVisit(newVisit)).isInstanceOf(DataAccessException.class);
    }

    @Test
    public void createVisit_invalidVisit_nullHunter() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        Visit newVisit = TestUtils.createVisit(); //TODO
        newVisit.setHunter(null);
        assertThatThrownBy(() -> service.createVisit(newVisit)).isInstanceOf(DataAccessException.class);
    }

    @Test
    public void createVisit_invalidVisit_nullDate() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        Visit newVisit = TestUtils.createVisit(); //TODO
        newVisit.setDate(null);
        assertThatThrownBy(() -> service.createVisit(newVisit)).isInstanceOf(DataAccessException.class);
    }

    @Test
    public void createVisit_duplicateVisit() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        Visit newVisit = TestUtils.createVisit(); //TODO
        newVisit.setForest(visit1.getForest());
        newVisit.setHunter(visit1.getHunter());
        newVisit.setDate(visit1.getDate());
        assertThatThrownBy(() -> service.createVisit(newVisit)).isInstanceOf(DataAccessException.class);
    }

    @Test
    public void createVisit_invalidVisit_hasId() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        Visit newVisit = TestUtils.createVisit(); //TODO
        newVisit.setId(15L);
        service.createVisit(newVisit);
        assertThatThrownBy(() -> service.createVisit(newVisit)).isInstanceOf(DataAccessException.class);
    }

    @Test
    public void deleteVisit_valid() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        service.deleteVisit(visit1);
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit2);

        service.deleteVisit(visit2);
        assertThat(persistedVisits.values()).isEmpty();
    }

    @Test
    public void deleteVisit_nullVisit() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        assertThatThrownBy(() -> service.deleteVisit(null)).isInstanceOf(DataAccessException.class);
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
    }

    @Test
    public void deleteVisit_invalidVisit_nullId() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        visit1.setId(null);
        assertThatThrownBy(() -> service.deleteVisit(visit1)).isInstanceOf(DataAccessException.class);
    }

    @Test
    public void deleteVisit_sameEntityTwice() {
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit1, visit2);
        service.deleteVisit(visit1);
        assertThat(persistedVisits.values()).containsExactlyInAnyOrder(visit2);
        
        assertThatThrownBy(() -> service.deleteVisit(visit1)).isInstanceOf(DataAccessException.class);
    }

    @Test
    public void updateVisit() {
    }

    @Test
    public void getVisitsByHunter() {
    }

    @Test
    public void getVisitsByForest() {
    }

    @Test
    public void getVisitsByMushroom() {
    }

}