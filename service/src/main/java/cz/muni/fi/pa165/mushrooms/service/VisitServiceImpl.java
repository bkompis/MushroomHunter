package cz.muni.fi.pa165.mushrooms.service;

import cz.muni.fi.pa165.mushrooms.dao.VisitDao;
import cz.muni.fi.pa165.mushrooms.entity.Forest;
import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import cz.muni.fi.pa165.mushrooms.entity.Visit;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Buvko
 */
@Service
public class VisitServiceImpl implements VisitService {

    @Inject
    private VisitDao visitDao;

    @Override
    public Visit findVisitById(Long id) throws DataAccessException{
        try {
            return visitDao.findById(id);
        } catch(Throwable e){
            throw new MushroomHunterServiceDataAccessException("Could not find visit by id in the database - error.", e);
        }
    }

    @Override
    public List<Visit> findAllVisits() throws DataAccessException{
        try {
            return visitDao.findAll();
        } catch(Throwable e){
            throw new MushroomHunterServiceDataAccessException("Could not find visits in the database - error.", e);
        }
    }

    @Override
    public List<Visit> findVisitByDate(LocalDate from, LocalDate to) throws DataAccessException{
        try {
            return visitDao.findByDate(from, to);
        } catch(Throwable e){
            throw new MushroomHunterServiceDataAccessException("Could not find visit by date in the database - error.", e);
        }
    }

    @Override
    public void createVisit(Visit visit) throws DataAccessException{
        try {
            visitDao.create(visit);
        }catch(Throwable e){
            throw new MushroomHunterServiceDataAccessException("Could not create new visit - error.", e);
        }
    }

    @Override
    public void deleteVisit(Visit visit) throws DataAccessException{
        try {
            visitDao.delete(visit);
        } catch(Throwable e){
            throw new MushroomHunterServiceDataAccessException("Could not delete visit - error.", e);
        }
    }

    @Override
    public void updateVisit(Visit visit) throws DataAccessException{
        try {
            visitDao.update(visit);
        }catch(Throwable e){
            throw new MushroomHunterServiceDataAccessException("Could not update visit - error.");
        }
    }

    @Override
    public List<Visit> getVisitsByHunter(MushroomHunter mushroomHunter) throws DataAccessException{
        if (mushroomHunter == null){
            throw new MushroomHunterServiceDataAccessException("Null hunter at finding visits.");
        }
        List<Visit> visitsByHunter = new ArrayList<>();
        List<Visit> visits = visitDao.findAll();

        for (Visit v: visits) {
            if (v.getHunter().equals(mushroomHunter)){
                visitsByHunter.add(v);
            }
        }
        return visitsByHunter;
    }

    @Override
    public List<Visit> getVisitsByForest(Forest forest) throws DataAccessException{
        if (forest == null){
            throw new MushroomHunterServiceDataAccessException("Null forest at finding visits.");
        }
        List<Visit> visitsByForest = new ArrayList<>();
        List<Visit> visits = findAllVisits(); // takes care of exceptions

        for (Visit v: visits) {
            if (v.getForest().equals(forest)){
                visitsByForest.add(v);
            }
        }
        return visitsByForest;
    }

    @Override
    public List<Visit> getVisitsByMushroom(Mushroom mushroom) throws DataAccessException{
        if (mushroom == null){
            throw new MushroomHunterServiceDataAccessException("Null mushroom at finding visits.");
        }
        List<Visit> visitsByMushroom = new ArrayList<>();
        List<Visit> visits = findAllVisits(); // takes care of exceptions
        List<Mushroom> mushrooms;

        for (Visit v: visits) {
            mushrooms = v.getMushrooms();
            for (Mushroom m : mushrooms) {
                if (m.equals(mushroom)){
                    visitsByMushroom.add(v);
                }
            }
        }
        return visitsByMushroom;
    }

}
