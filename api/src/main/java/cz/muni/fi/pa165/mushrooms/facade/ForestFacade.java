package cz.muni.fi.pa165.mushrooms.facade;

import cz.muni.fi.pa165.mushrooms.dto.ForestDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomDTO;
import cz.muni.fi.pa165.mushrooms.dto.VisitDTO;

import java.util.List;

/**
 * TODO: create  javadoc
 *
 * @author bencikpeter, bohdancvejn, bkompis, Lindar84, Buvko
 */
public interface ForestFacade {

    ForestDTO findByName(String name);

    ForestDTO findById(String name);

    ForestDTO findByMushroom(MushroomDTO mushroom);

    void deleteForest(ForestDTO forest);

    void updateForest(ForestDTO forest);

    void createForest(ForestDTO forest);

    List<ForestDTO> listAllForestWithMushroom(MushroomDTO mushroom); //complicated business function

}
