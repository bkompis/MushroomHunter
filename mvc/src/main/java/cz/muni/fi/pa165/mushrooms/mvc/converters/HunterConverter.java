package cz.muni.fi.pa165.mushrooms.mvc.converters;

import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterDTO;
import cz.muni.fi.pa165.mushrooms.facade.MushroomHunterFacade;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by matus.panik on 18.12.2017.
 */
@Component
public class HunterConverter implements Converter<String, MushroomHunterDTO>{

    @Inject
    private MushroomHunterFacade mushroomHunterFacade;

    @Override
    public MushroomHunterDTO convert(String s) {
        return mushroomHunterFacade.findHunterById(Long.decode(s));
    }

}
