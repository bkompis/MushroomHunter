package cz.muni.fi.pa165.mushrooms.service;

import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for operations concerning mushroom hunters, users of the system.
 *
 * @author bkompis
 */
@Service
public interface MushroomHunterService {
    MushroomHunter findHunterById(Long id) throws DataAccessException;

    MushroomHunter findHunterByNickname(String nickname) throws DataAccessException;

    void registerHunter(MushroomHunter hunter, String password) throws DataAccessException;

    void deleteHunter(MushroomHunter hunter) throws DataAccessException;

    void updateHunter(MushroomHunter hunter) throws DataAccessException;

    boolean updatePassword(MushroomHunter hunter, String oldPassword, String newPassword) throws DataAccessException;

    List<MushroomHunter> findAllHunters() throws DataAccessException;

    boolean authenticate(MushroomHunter hunter, String password) throws DataAccessException;

    boolean isAdmin(MushroomHunter hunter) throws DataAccessException;
}
