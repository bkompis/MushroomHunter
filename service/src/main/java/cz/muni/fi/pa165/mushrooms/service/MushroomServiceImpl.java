package cz.muni.fi.pa165.mushrooms.service;

import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.mushrooms.dao.MushroomDao;
import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.enums.MushroomType;
import cz.muni.fi.pa165.mushrooms.service.exceptions.EntityFindServiceException;
import cz.muni.fi.pa165.mushrooms.service.exceptions.EntityOperationServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * Implementation of business logic for Mushroom.
 *
 * @author Lindar84
 */
@Service
public class MushroomServiceImpl implements MushroomService {

    @Inject
    private MushroomDao mushroomDao;

    @Override
    public List<Mushroom> findAllMushrooms() throws DataAccessException {
        try {
            return mushroomDao.findAll();
        } catch (Throwable e) {
            throw new EntityFindServiceException("all mushrooms", e);
        }
    }

    @Override
    public Mushroom findMushroomById(Long id) throws DataAccessException {
        try {
            return mushroomDao.findById(id);
        } catch (Throwable e) {
            throw new EntityFindServiceException("mushroom", "id", id, e);
        }
    }

    @Override
    public Mushroom findMushroomByName(String name) throws DataAccessException {
        try {
            return mushroomDao.findByName(name);
        } catch (Throwable e) {
            throw new EntityFindServiceException("mushroom", "name", name, e);
        }
    }

    @Override
    public List<Mushroom> findByMushroomType(MushroomType mushroomType) throws DataAccessException {
        try {
            return mushroomDao.findByMushroomType(mushroomType);
        } catch (Throwable e) {
            throw new EntityFindServiceException("mushroom", "type", mushroomType, e);
        }
    }

    @Override
    public List<Mushroom> findByIntervalOfOccurrence(String fromMonth, String toMonth) throws DataAccessException {  ////// TODO String - Date
        try {
            return mushroomDao.findByIntervalOfOccurrence(fromMonth, toMonth);
        } catch (Throwable e) {
            throw new EntityFindServiceException(
                    "mushroom", "internal of occurence ", fromMonth + " - " + toMonth, e);
        }
    }

    @Override
    public Mushroom createMushroom(Mushroom mushroom) throws DataAccessException {
        try {
            mushroomDao.create(mushroom);
            return mushroom;
        } catch (Throwable e) {
            throw new EntityOperationServiceException("mushroom", "create", mushroom, e);
        }
    }

    @Override
    public void deleteMushroom(Mushroom mushroom) throws DataAccessException {
        try {
            mushroomDao.delete(mushroom);
        } catch (Throwable e) {
            throw new EntityOperationServiceException("mushroom", "delete", mushroom, e);
        }
    }

    @Override
    public void updateMushroom(Mushroom mushroom) throws DataAccessException {
        try {
            mushroomDao.update(mushroom);
        } catch (Throwable e) {
            throw new EntityOperationServiceException("mushroom", "update", mushroom, e);
        }
    }
}
