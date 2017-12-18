package cz.muni.fi.pa165.mushrooms.mvc.converters;

import cz.muni.fi.pa165.mushrooms.dto.ForestDTO;
import cz.muni.fi.pa165.mushrooms.facade.ForestFacade;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by matus.panik on 18.12.2017.
 */
@Component
public class ForestConverter implements Converter<String, ForestDTO>{

    @Inject
    private ForestFacade forestFacade;

    @Override
    public ForestDTO convert(String s) {
        return forestFacade.findById(Long.decode(s));
    }

}
