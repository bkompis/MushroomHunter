package cz.muni.fi.pa165.mushrooms.service;

import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.mushrooms.dao.ForestDao;
import cz.muni.fi.pa165.mushrooms.entity.Forest;
import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.service.exceptions.EntityFindServiceException;
import cz.muni.fi.pa165.mushrooms.service.exceptions.EntityOperationServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author bencikpeter
 */
@Service
public class ForestServiceImpl implements ForestService {

    @Inject
    private ForestDao forestDao;

    public List<Forest> findAllForests() throws DataAccessException {
        try {
            return forestDao.findAll();
        } catch (Throwable e) {
            throw new EntityFindServiceException("all forests", e);
        }
    }

    @Override
    public Forest findForestByName(String name) throws DataAccessException {
        try {
            return forestDao.findByName(name);
        } catch (Throwable e) {
            throw new EntityFindServiceException("forest", "name", name, e);
        }
    }

    @Override
    public Forest findForestById(Long id) throws DataAccessException {
        try {
            return forestDao.findById(id);
        } catch (Throwable e) {
            throw new EntityFindServiceException("forest", "id", id, e);
        }
    }

    @Override
    public void deleteForest(Forest forest) throws DataAccessException {
        try {
            forestDao.delete(forest);
        } catch (Throwable e) {
            throw new EntityOperationServiceException("forest", "delete", forest, e);
        }
    }

    @Override
    public void updateForest(Forest forest) throws DataAccessException {
        try {
            forestDao.update(forest);
        } catch (Throwable e) {
            throw new EntityOperationServiceException("forest", "update", forest, e);
        }
    }

    @Override
    public void createForest(Forest forest) throws DataAccessException {
        try {
            forestDao.create(forest);
        } catch (Throwable e) {
            throw new EntityOperationServiceException("forest", "create", forest, e);
        }
    }

    @Override
    public List<Forest> findAllForestsWithMushroom(Mushroom mushroomEntity) throws DataAccessException {
        return null; //TODO: do we need this?
    }
}
