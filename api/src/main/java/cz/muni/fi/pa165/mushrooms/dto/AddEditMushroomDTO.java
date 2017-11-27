package cz.muni.fi.pa165.mushrooms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cz.muni.fi.pa165.mushrooms.enums.MushroomType;

/**
 * Created by Matúš on 18.11.2017.
 */
public class AddEditMushroomDTO {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    private MushroomType type;

    @NotNull
    private String intervalOfOccurrence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MushroomType getType() {
        return type;
    }

    public void setType(MushroomType type) {
        this.type = type;
    }

    public String getIntervalOfOccurrence() {
        return intervalOfOccurrence;
    }

    public void setIntervalOfOccurrence(String intervalOfOccurrence) {
        this.intervalOfOccurrence = intervalOfOccurrence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MushroomDTO)) return false;

        MushroomDTO that = (MushroomDTO) o;

        if (!getName().equals(that.getName())) return false;
        if (getType() != that.getType()) return false;
        return getIntervalOfOccurrence().equals(that.getIntervalOfOccurrence());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getIntervalOfOccurrence().hashCode();
        return result;
    }
}
