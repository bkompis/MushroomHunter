package cz.muni.fi.pa165.mushrooms.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The DTO to be used at user creation.
 *
 * @author bkompis
 */
public class MushroomHunterCreateDTO {
    @NotNull
    @Size(min = 3, max = 50)
    private String userNickname;
    @NotNull
    @Size(min = 8, max = 150)
    private String unencryptedPassword;
    @NotNull
    @Size(min = 3, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 3, max = 50)
    private String surname;
    private String personalInfo;
    private boolean admin;
    private Set<VisitDTO> visits = new HashSet<>(); //TODO: check this

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUnencryptedPassword() {
        return unencryptedPassword;
    }

    public void setUnencryptedPassword(String unencryptedPassword) {
        this.unencryptedPassword = unencryptedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Set<VisitDTO> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitDTO> visits) {
        this.visits = visits;
    }
}
