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
    /**
     * Find all registered mushroom hunters.
     *
     * @return a list of all found hunters, empty list if none are found.
     */
    List<MushroomHunterDTO> findAllHunters();

    /**
     * Find a mushroom hunter by id.
     *
     * @param hunterId the ID of the hunter, non-null
     * @return a MushroomHunterDTO object if found, null otherwise
     */
    MushroomHunterDTO findHunterById(Long hunterId);

    /**
     * Find a mushroom hunter by nickname.
     *
     * @param nickname the nickname to search by, non-null
     * @return a MushroomHunterDTO object if found, null otherwise
     */
    MushroomHunterDTO findHunterByNickname(String nickname);

    /**
     * Register the mushroom hunter with the given unencrypted password.
     *
     * @param hunter the MushroomHunter to register, non-null
     * @return the DTO object representing the new entity
     */
    MushroomHunterDTO registerHunter(MushroomHunterCreateDTO hunter);

    /**
     * Delete the given mushroom hunter from the user database.
     *
     * @param id the id of the hunter to delete
     * @return true if the user was successfully deleted
     */
    boolean deleteHunter(Long id);

    /**
     * Update a mushroom hunter's attributes.
     *
     * @param hunter the hunter to update
     * @return a DTO object containing the updated data
     */
    MushroomHunterDTO updateHunter(MushroomHunterUpdateDTO hunter);

    /**
     * Update a mushroom hunter's password.
     *
     * @param hunter the hunter to update with the new password
     * @return a DTO object containing the updated data
     */
    MushroomHunterDTO updatePassword(MushroomHunterUpdatePasswordDTO hunter);

    /**
     * Attempt to authenticate a mushroom hunter.
     *
     * @param hunter the hunter to authenticate
     * @return true if the authentication succeeded, false otherwise.
     */
    boolean authenticate(MushroomHunterAuthenticateDTO hunter);


    /**
     * Check if the given mushroom hunter has administrator privileges.
     *
     * @param hunter the MushroomHunter to check
     * @return true if the hunter is an administrator, false otherwise
     */
    boolean isAdmin(MushroomHunterDTO hunter);
}
