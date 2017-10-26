package cz.muni.fi.pa165.mushrooms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Buvko
 */
@Entity
public class MushroomHunter {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String surname;

    private boolean isAdmin;

    private String personalInfo;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "MushroomHunter{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", personalInfo='" + personalInfo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MushroomHunter)) return false;

        MushroomHunter mushroomHunter = (MushroomHunter) o;

        if (!getFirstName().equals(mushroomHunter.getFirstName())) return false;
        if (!getSurname().equals(mushroomHunter.getSurname())) return false;
        return getPersonalInfo() != null ? getPersonalInfo().equals(mushroomHunter.getPersonalInfo()) : mushroomHunter.getPersonalInfo() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + (getPersonalInfo() != null ? getPersonalInfo().hashCode() : 0);
        return result;
    }

}
