package cz.muni.fi.pa165.mushrooms.service.exceptions;

/**
 * @author bkompis
 */
public class EntityFindServiceException extends MushroomHunterServiceDataAccessException {
    public <T> EntityFindServiceException(String entity, String what, T id, Throwable cause) {
        this(entity + " by " + what + " (" + id + ")", cause);
    }

    public EntityFindServiceException(String msg, Throwable cause) {
        super("Could not find " + msg + " in the database.", cause);
    }

    public EntityFindServiceException(String msg) {
        super(msg);
    }
}
