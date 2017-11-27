package cz.muni.fi.pa165.mushrooms.service;

import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.enums.MushroomType;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for operations concerning mushrooms.
 *
 * @author Lindar84
 */
@Service
public interface MushroomService {

    List<Mushroom> findAllMushrooms() throws DataAccessException;

    Mushroom findMushroomById(Long id) throws DataAccessException;

    Mushroom findMushroomByName(String name) throws DataAccessException;

    List<Mushroom> findByMushroomType(MushroomType mushroomType) throws DataAccessException;

    List<Mushroom> findByIntervalOfOccurrence(String fromMonth, String toMonth) throws DataAccessException;  ///////// TODO String - Date

    Mushroom createMushroom(Mushroom mushroom) throws DataAccessException;

    void deleteMushroom(Mushroom mushroom) throws DataAccessException;

    void updateMushroom(Mushroom mushroom) throws DataAccessException;

}
