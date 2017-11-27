package cz.muni.fi.pa165.mushrooms.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The basic DTO class for the MushroomHunter entity.
 *
 * @author bkompis
 */
public class MushroomHunterDTO {
    private Long id;
    private String userNickname;
    private String firstName;
    private String surname;
    private String personalInfo;
    private boolean admin;
    private List<VisitDTO> visits = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
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

    public List<VisitDTO> getVisits() {
        return visits;
    }

    public void setVisits(List<VisitDTO> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "MushroomHunter{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", personalInfo='" + personalInfo + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserNickname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof MushroomHunterDTO)) {
            return false;
        }

        MushroomHunterDTO mushroomHunter = (MushroomHunterDTO) o;
        return Objects.equals(getUserNickname(), mushroomHunter.getUserNickname());
    }
}
