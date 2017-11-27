package cz.muni.fi.pa165.mushrooms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * TThe DTO object for updating user password.
 *
 * @author bkompis
 */
public class MushroomHunterUpdatePasswordDTO {
    private Long id;
    @NotNull
    @Size(min = 8, max = 150)
    private String oldPassword;
    @NotNull
    @Size(min = 8, max = 150)
    private String newPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
