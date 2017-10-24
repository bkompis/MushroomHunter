package cz.muni.fi.pa165.mushrooms.dao;

import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;

import java.util.List;

/**
 * Created by Buvko on 20.10.2017.
 */
public interface MushroomHunterDao {
    public MushroomHunter findById(Long id);
    public void create(MushroomHunter c);
    public void delete(MushroomHunter c);
    public List<MushroomHunter> findAll();
    public MushroomHunter findByFirstName(String firstName);
    public MushroomHunter findBySurname(String surname);
}

