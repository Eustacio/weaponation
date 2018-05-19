package com.weaponation.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Wallison Freitas
 */
@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer extends BaseEntity {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 30;

    @NotBlank
    @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH)
    @Column(name = "NAME", unique = true, nullable = false, length = MAX_NAME_LENGTH)
    private String name;

    protected Manufacturer() {
        // An no argument constructor is required by JPA specification
    }

    public Manufacturer(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Manufacturer)) return false;

        Manufacturer that = (Manufacturer) obj;
        return this.getName() == null ? that.getName() == null :
                this.getName().equalsIgnoreCase(that.getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}
