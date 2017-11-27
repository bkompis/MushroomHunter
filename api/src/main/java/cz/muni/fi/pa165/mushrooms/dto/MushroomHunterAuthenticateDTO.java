package cz.muni.fi.pa165.mushrooms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The DTO for transferring data relevant to a user login attempt.
 *
 * @author bkompis
 */
public class MushroomHunterAuthenticateDTO {
    private Long id;
    @NotNull
    @Size(min = 8, max = 150)
    private String unencryptedPassword;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return unencryptedPassword;
    }

    public void setPassword(String password)
    {
        this.unencryptedPassword = password;
    }
}
