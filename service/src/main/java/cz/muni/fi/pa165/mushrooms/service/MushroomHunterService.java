package cz.muni.fi.pa165.mushrooms.service;
import cz.muni.fi.pa165.mushrooms.entity.MushroomHunter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for operations concerning mushroom hunters, users of the system.
 *
 * @author bkompis
 */
@Service
public interface MushroomHunterService {
    MushroomHunter findHunterById(Long id);
    MushroomHunter findHunterByNickname(String nickname);
    void registerHunter(MushroomHunter hunter, String password);
    void deleteHunter(MushroomHunter hunter);
    void updateHunter(MushroomHunter hunter);
    boolean updatePassword(MushroomHunter hunter, String oldPassword, String newPassword);
    List<MushroomHunter> findAllHunters();
    boolean authenticate(MushroomHunter hunter, String password);
    boolean isAdmin(MushroomHunter hunter);
}
