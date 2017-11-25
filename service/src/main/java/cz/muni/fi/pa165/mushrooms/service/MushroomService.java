package cz.muni.fi.pa165.mushrooms.service;

import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.enums.MushroomType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for operations concerning mushrooms.
 *
 * @author Lindar84
 */
@Service
public interface MushroomService {

    List<Mushroom> findAllMushrooms();
    Mushroom findMushroomById(Long id);
    Mushroom findMushroomByName(String name);
    List<Mushroom> findByMushroomType(MushroomType mushroomType);
    List<Mushroom> findByIntervalOfOccurrence(String fromMonth, String toMonth);  ///////// TODO String - Date
    Mushroom createMushroom(Mushroom mushroom);
    void deleteMushroom(Mushroom mushroom);
    void updateMushroom(Mushroom mushroom);

}
