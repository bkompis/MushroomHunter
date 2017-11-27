package cz.muni.fi.pa165.mushrooms.service.exceptions;

import org.springframework.dao.DataAccessException;

/**
 * @author bkompis
 */
public class MushroomHunterServiceDataAccessException extends DataAccessException {
    public MushroomHunterServiceDataAccessException(String msg) {
        super(msg);
    }

    public MushroomHunterServiceDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
