package cz.muni.fi.pa165.mushrooms.service.facade;

import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterAuthenticateDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterCreateDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterUpdateDTO;
import cz.muni.fi.pa165.mushrooms.dto.MushroomHunterUpdatePasswordDTO;
import cz.muni.fi.pa165.mushrooms.facade.MushroomHunterFacade;

import java.util.List;

/**
 * @author bkompis
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
    public void registerHunter(MushroomHunterCreateDTO hunter) {

    }

    @Override
    public void deleteHunter(MushroomHunterDTO hunter) {

    }

    @Override
    public void updateHunter(MushroomHunterUpdateDTO hunter) {

    }

    @Override
    public void updatePassword(MushroomHunterUpdatePasswordDTO hunter) {

    }

    @Override
    public List<MushroomHunterDTO> findAllHunters() {
        return null;
    }

    @Override
    public boolean authenticate(MushroomHunterAuthenticateDTO u) {
        return false;
    }

    @Override
    public boolean isAdmin(MushroomHunterDTO u) {
        return false;
    }
}
