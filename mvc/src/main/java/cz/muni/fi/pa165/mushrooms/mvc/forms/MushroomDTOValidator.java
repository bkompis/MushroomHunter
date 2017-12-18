package cz.muni.fi.pa165.mushrooms.mvc.forms;

import cz.muni.fi.pa165.mushrooms.dto.MushroomDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bencikpeter
 */

public class MushroomDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return MushroomDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MushroomDTO dto = (MushroomDTO) o;
        String pattern = "(.*) - (.*)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(dto.getIntervalOfOccurrence());
        if (!m.matches()){
            errors.rejectValue("intervalOfOccurrence", "MushroomDTOValidator.intervalOfOccurence.wrongFormat");
        }

    }
}
