package cz.muni.fi.pa165.mushrooms.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * The DTO to be used for Forest creation and update.
 *
 * @author BohdanCvejn
 */

public class AddEditForestDTO {

    @NotNull
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddEditForestDTO)) return false;

        AddEditForestDTO AddEditForestDTO = (AddEditForestDTO) o;
        return Objects.equals(getName(), AddEditForestDTO.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }
}
