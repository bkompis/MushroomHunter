package cz.muni.fi.pa165.mushrooms.service.facade;

import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterDTO;
import cz.muni.fi.pa165.mushrooms.facade.MushroomHunterFacade;

import java.util.List;

/**
 * TODO: create  javadoc
 *
 * @author Barbora Kompisova
 */
public class MushroomHunterFacadeImpl implements MushroomHunterFacade {
    @Override
    public MushroomHunterDTO findHunterById(Long userId) {
        return null;
    }

    @Override
    public MushroomHunterDTO findHunterByNickname(String nickname) {
        return null;
    }

    @Override
    public void registerHunter(MushroomHunterDTO hunter, String unencryptedPassword) {

    }

    @Override
    public void deleteHunter(MushroomHunterDTO hunter) {

    }

    @Override
    public void updateHunter(MushroomHunterDTO hunter) {

    }

    @Override
    public void updatePassword(MushroomHunterDTO hunter, String oldUnencryptedPassword, String newUnencryptedPassword) {

    }

    @Override
    public List<MushroomHunterDTO> findAllHunters() {
        return null;
    }

    @Override
    public boolean authenticate(MushroomHunterDTO u) {
        return false;
    }

    @Override
    public boolean isAdmin(MushroomHunterDTO u) {
        return false;
    }
}
