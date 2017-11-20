package cz.muni.fi.pa165.mushrooms.dto;

/**
 * The DTO for transferring data relevant to a user login attempt.
 *
 * @author bkompis
 */
public class MushroomHunterAuthenticateDTO {
    private Long id;
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
