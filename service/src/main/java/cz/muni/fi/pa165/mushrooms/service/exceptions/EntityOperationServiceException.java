package cz.muni.fi.pa165.mushrooms.service.exceptions;

/**
 * @author bkompis
 */
public class EntityOperationServiceException extends MushroomHunterServiceDataAccessException {

    public <T> EntityOperationServiceException(String what, String operation, T entity, Throwable e) {
        super("Could not " + operation + " " + what + " (" + entity + ").", e);
    }

    public EntityOperationServiceException(String msg) {
        super(msg);
    }

    public EntityOperationServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
