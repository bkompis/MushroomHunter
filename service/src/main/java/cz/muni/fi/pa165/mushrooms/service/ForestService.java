package cz.muni.fi.pa165.mushrooms.service;

import cz.muni.fi.pa165.mushrooms.entity.Forest;
import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: create  javadoc
 *
 * @author bencikpeter
 */
public interface ForestService {

    List<Forest> findAllForests() throws DataAccessException;

    Forest findForestByName(String name) throws DataAccessException;

    Forest findForestById(Long id) throws DataAccessException;

    void deleteForest(Forest forest) throws DataAccessException;

    void updateForest(Forest forest) throws DataAccessException;

    void createForest(Forest forest) throws DataAccessException;

    List<Forest> findAllForestsWithMushroom(Mushroom mushroomEntity) throws DataAccessException;
}
