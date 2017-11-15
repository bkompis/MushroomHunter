package cz.muni.fi.pa165.mushrooms.service.facade;

import cz.muni.fi.pa165.mushrooms.dto.MushroomDTO;
import cz.muni.fi.pa165.mushrooms.enums.MushroomType;
import cz.muni.fi.pa165.mushrooms.facade.MushroomFacade;

import java.util.List;

/**
 * TODO: create  javadoc
 *
 * @author Barbora Kompisova
 */
public class MushroomFacadeImpl implements MushroomFacade {
    @Override
    public List<MushroomDTO> findAllMushrooms() {
        return null;
    }

    @Override
    public MushroomDTO findMushroomById(Long userId) {
        return null;
    }

    @Override
    public MushroomDTO findMushroomByName(String name) {
        return null;
    }

    @Override
    public MushroomDTO findByMushroomType(MushroomType mushroomType) {
        return null;
    }

    @Override
    public MushroomDTO findByIntervalOfOccurrence(String fromMonth, String toMonth) {
        return null;
    }

    @Override
    public void createMushroom(MushroomDTO mushroom) {

    }

    @Override
    public void deleteMushroom(MushroomDTO mushroom) {

    }

    @Override
    public void updateMushroom(MushroomDTO mushroom) {

    }
}
