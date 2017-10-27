package cz.muni.fi.pa165.mushrooms.entity;

import cz.muni.fi.pa165.mushrooms.enums.MushroomType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lindar84
 */
@Entity
public class Mushroom {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable=false, unique = true)
    private String name;

    @NotNull
    @Column(nullable=false)
    private MushroomType type;

    @NotNull
    @Column(nullable=false)
    private String intervalOfOccurence;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getIntervalOfOccurence() {
        return intervalOfOccurence;
    }

    // "... in the following string format: "June - July" (month - month)"
    // - is String enought? Wouldn't we need to use the dates for some sorting of mushrooms?
    public void setIntervalOfOccurence(String startMonth, String endMonth) {
        this.intervalOfOccurence = startMonth + " - " + endMonth;
    }

    // Do we want to write ID?
    @Override
    public String toString() {
        return "Mushroom{" +
                "name = '" + name + '\'' +
                ", type = " + type +
                ", interval of occurence = '" + intervalOfOccurence + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Mushroom)) return false;

        Mushroom mushroom = (Mushroom) o;

        if(!name.equals(mushroom.name)) return false;
        if(!type.equals(mushroom.type)) return false;
        return intervalOfOccurence.equals(mushroom.intervalOfOccurence);
    }

    @Override
    public int hashCode() {
        return 37 * name.hashCode() * type.hashCode() * intervalOfOccurence.hashCode();
    }

}
