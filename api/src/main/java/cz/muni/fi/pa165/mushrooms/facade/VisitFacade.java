package cz.muni.fi.pa165.mushrooms.facade;

import cz.muni.fi.pa165.mushrooms.dto.ForestDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterDTO;
import cz.muni.fi.pa165.mushrooms.dto.VisitDTO;

import java.util.List;

/**
 * TODO: create  javadoc
 *
 * @author  bencikpeter, bohdancvejn, bkompis, Lindar84, Buvko
 */
public interface VisitFacade {

    VisitDTO findById(String name);

    void deleteVisit(VisitDTO visit);

    void updateVisit(VisitDTO visit);

    void createVisit(VisitDTO visit);

    List<VisitDTO> listAllVisitsForForest(ForestDTO forest);

    List<VisitDTO> listAllVisitsForMushromHunter(MushroomHunterDTO mushroomHunter);

    //List<VisitDTO> listAllVisitsByMushroom(MushroomDTO mushroom);

}
