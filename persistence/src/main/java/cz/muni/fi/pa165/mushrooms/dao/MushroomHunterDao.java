package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;

import java.util.List;

/**
 * @author Buvko
 */
public interface MushroomHunterDao {

    /**
     * Takes unique id of MushroomHunter and returns entity with this id
     *
     * @param id of Forest object, non-null
     * @return Forest entity if found, null otherwise
     */
    MushroomHunter findById(Long id);

    /**
     * Stores the MushroomHunter entity into persistent database
     *
     * @param mh MushroomHunter object
     */
    void create(MushroomHunter mh);

    /**
     * Deletes the MushroomHunter entry from persistent database
     *
     * @param mh MushroomHunter object
     */
    void delete(MushroomHunter mh);

    /**
     * Update a visit in the database with new values.
     *
     * @param mh MushroomHunter object to update
     */
    void update(MushroomHunter mh);

    /**
     * Returns the list of all MushroomHunter entities stored in database
     */
    List<MushroomHunter> findAll();

    /**
     * Returns the list all MushroomHunter entities with given first name
     *
     * @param firstName String object, search criteria for MushroomHunter entity
     */
    List<MushroomHunter> findByFirstName(String firstName);

    /**
     * Returns the list all MushroomHunter entities with given surname
     *
     * @param surname String object, search criteria for MushroomHunter entity
     */
    List<MushroomHunter> findBySurname(String surname);

    /**
     * Returns the list all MushroomHunter entities with given nickname
     *
     * @param userNickname String object, search criteria for MushroomHunter entity
     */
    List<MushroomHunter> findByNickame(String userNickname);
}

