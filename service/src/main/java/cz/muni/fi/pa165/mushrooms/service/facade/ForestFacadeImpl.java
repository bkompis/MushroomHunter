package cz.muni.fi.pa165.mushrooms.service.facade;

import cz.muni.fi.pa165.mushrooms.dto.ForestDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomDTO;
import cz.muni.fi.pa165.mushrooms.entity.Forest;
import cz.muni.fi.pa165.mushrooms.entity.Mushroom;
import cz.muni.fi.pa165.mushrooms.facade.ForestFacade;
import cz.muni.fi.pa165.mushrooms.service.BeanMappingService;
import cz.muni.fi.pa165.mushrooms.service.ForestService;
import cz.muni.fi.pa165.mushrooms.service.MushroomService;

import javax.inject.Inject;
import java.util.List;

/**
 * TODO: create  javadoc
 *
 * @author bencikpeter
 */
public class ForestFacadeImpl implements ForestFacade {

    @Inject
    private ForestService service;

    @Inject
    private MushroomService mushroomService;

    @Inject
    private BeanMappingService beanMappingService;


    @Override
    public ForestDTO findByName(String name) {
        Forest forest = service.findForestByName(name);
        //TODO: logging?
        if(forest == null) return null;
        ForestDTO forestDTO = beanMappingService.mapTo(forest, ForestDTO.class);
        return forestDTO;
    }

    @Override
    public ForestDTO findById(Long id) {
        Forest forest = service.findForestById(id);
        //TODO: logging?
        if(forest == null) return null;
        ForestDTO forestDTO = beanMappingService.mapTo(forest, ForestDTO.class);
        return forestDTO;
    }

    @Override
    public void deleteForest(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Null id at forest delete.");
        }
        Forest forest = service.findForestById(id);
        service.deleteForest(forest);
        return;
    }

    @Override
    public void updateForest(ForestDTO forest) {
        if (forest == null){
            throw new IllegalArgumentException("Null forestDTO cannot be updated");
        }
        Forest entityForest = service.findForestById(forest.getId());
        if (entityForest == null){
            //TODO: react to it somehow
        }
        entityForest.setDescription(forest.getDescription());
        entityForest.setName(forest.getName());
        service.updateForest(entityForest);

    }

    @Override
    public void createForest(ForestDTO forest) {
        if (forest == null){
            throw new IllegalArgumentException("Null forestDTO cannot be updated");
        }
        Forest newForest = new Forest();
        newForest.setName(forest.getName());
        newForest.setDescription(forest.getDescription());

        service.createForest(newForest);
    }

    @Override
    public List<ForestDTO> listAllForestsWithMushroom(MushroomDTO mushroom) {
        if (mushroom == null) throw new IllegalArgumentException();
        Mushroom mushroomEntity = mushroomService.findMushroomById(mushroom.getId());

        List<Forest> forestsEntities = service.findAllForestsWithMushroom(mushroomEntity);

        return beanMappingService.mapTo(forestsEntities, ForestDTO.class);
    }
}
