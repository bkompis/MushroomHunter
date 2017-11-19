package cz.muni.fi.pa165.mushrooms.dto;

/**
 * The DTO for transferring data relevant to a user login attempt.
 *
 * @author bkompis
 */
public class MushroomHunterAuthenticateDTO {
    private Long userId;
    private String unencryptedPassword;

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
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
