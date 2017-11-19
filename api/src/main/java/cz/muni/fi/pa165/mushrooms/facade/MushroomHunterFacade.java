package cz.muni.fi.pa165.mushrooms.facade;

import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterAuthenticateDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterCreateDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterUpdateDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterUpdatePasswordDTO;

import java.util.List;

/**
 * @author bencikpeter, bohdancvejn, bkompis, Lindar84, Buvko
 */
public interface MushroomHunterFacade {
    //TODO: constraints, exceptions in javadoc
    //TODO: missing equals()in DTOs?
    /**
     * Find a MushroomHunter by id.
     *
     * @param userId the ID of the hunter
     * @return a MushroomHunterDTO object if found, null otherwise //TODO null?
     */
    MushroomHunterDTO findHunterById(Long userId);

    /**
     * Find a MushroomHunter by nickname.
     *
     * @param nickname the nickname to search by
     * @return a MushroomHunterDTO object if found, null otherwise //TODO null?
     */
    MushroomHunterDTO findHunterByNickname(String nickname);

    /**
     * Register the MushroomHunter with the given unencrypted password.
     *
     * @param hunter the MushroomHunter to register
     */
    void registerHunter(MushroomHunterCreateDTO hunter);

    /**
     * Delete the given MushroomHunter from the user database.
     *
     * @param hunter the hunter to delete
     */
    //TODO: maybe use ID in delete
    void deleteHunter(MushroomHunterDTO hunter);

    /**
     * Update a MushroomHunter's attributes.
     *
     * @param hunter the hunter to update
     */
    void updateHunter(MushroomHunterUpdateDTO hunter);

    /**
     * Update a MushroomHunter's password.
     *
     * @param hunter the hunter to update with the new password
     */
    void updatePassword(MushroomHunterUpdatePasswordDTO hunter);
    
    /**
     * Find all registered users
     * @return a list of all found hunters
     */
    List<MushroomHunterDTO> findAllHunters();


    /**
     * Attempt to authenticate a MushroomHunter.
     *
     * @param u the hunter to authenticate
     * @return true if the authentication succeeded, false otherwise.
     */
    boolean authenticate(MushroomHunterAuthenticateDTO u);


    /**
     * Check if the given mushroom hunter has administrator privileges.
     *
     * @param u the MushroomHunter to check
     * @return true if the hunter is an administrator, false otherwise
     */
    boolean isAdmin(MushroomHunterDTO u);
}
