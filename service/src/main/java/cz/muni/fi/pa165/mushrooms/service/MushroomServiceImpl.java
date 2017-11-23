package cz.muni.fi.pa165.mushrooms.service;

import cz.muni.fi.pa165.mushrooms.dao.MushroomDao;
import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.enums.MushroomType;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

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
    public List<Mushroom> findAllMushrooms() {
        return mushroomDao.findAll();
    }

    @Override
    public Mushroom findMushroomById(Long id) {
        return mushroomDao.findById(id);
    }

    @Override
    public Mushroom findMushroomByName(String name) {
        return mushroomDao.findByName(name);
    }

    @Override
    public List<Mushroom> findByMushroomType(MushroomType mushroomType) {
        return mushroomDao.findByMushroomType(mushroomType);
    }

    @Override
    public List<Mushroom> findByIntervalOfOccurrence(String fromMonth, String toMonth) {  ////// TODO String - Date
        return mushroomDao.findByIntervalOfOccurrence(fromMonth, toMonth);
    }

    @Override
    public Mushroom createMushroom(Mushroom mushroom) {
        mushroomDao.create(mushroom);
        return mushroom;
    }

    @Override
    public void deleteMushroom(Mushroom mushroom) {
        mushroomDao.delete(mushroom);
    }

    @Override
    public void updateMushroom(Mushroom mushroom) {
        mushroomDao.update(mushroom);
    }
}
