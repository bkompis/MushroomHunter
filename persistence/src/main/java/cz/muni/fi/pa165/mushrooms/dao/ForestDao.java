package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.Forest;

import java.util.List;

/**
 * @author bencikpeter
 */

public interface ForestDao {

    /**
     * Takes unique id of Forest and returns a corresponding entity if found
     *
     * @param id of Forest object, non-null
     * @return Forest entity if found, null otherwise
     */
    public Forest findById(Long id);

    /**
     * Takes an object of type Forest and creates an entry in a database
     *
     * @param forest non-null object to be created in a database
     */
    public void create(Forest forest);

    /**
     * Takes a forest object that shall be deleted from database
     *
     * @param forest non-null object to be deleted from the database
     */
    public void delete(Forest forest);

    /**
     * Returns all Forests in the database
     *
     * @return List of all Forests, empty List if no Forest is found
     */
    public List<Forest> findAll();

    /**
     * Takes unique name of Forest and returns a corresponding entity if found
     *
     * @param name non-null string representing name
     * @return forest with given name if exists, null otherwise
     */
    public Forest findByName(String name);

}
