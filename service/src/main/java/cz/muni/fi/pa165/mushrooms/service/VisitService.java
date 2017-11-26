package cz.muni.fi.pa165.mushrooms.service;

import cz.muni.fi.pa165.mushrooms.entity.Forest;
import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import cz.muni.fi.pa165.mushrooms.entity.Visit;
import org.springframework.dao.DataAccessException;

import java.time.LocalDate;
import java.util.List;

/**
 * TODO: create  javadoc
 *
 * @author Buvko
 */
public interface VisitService {
    Visit findVisitById(Long id) throws DataAccessException;

    List<Visit> findAllVisits() throws DataAccessException;

    List<Visit> findVisitByDate(LocalDate from, LocalDate to) throws DataAccessException;

    void createVisit(Visit visit) throws DataAccessException;

    void deleteVisit(Visit visit) throws DataAccessException;

    void updateVisit(Visit visit) throws DataAccessException;

    List<Visit> getVisitsByHunter(MushroomHunter mushroomHunter) throws DataAccessException;

    List<Visit> getVisitsByForest(Forest forest) throws DataAccessException;

    List<Visit> getVisitsByMushroom(Mushroom mushroom) throws DataAccessException;
}
