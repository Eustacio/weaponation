package com.weaponation.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Wallison Freitas
 */
@Entity
@Table(name = "PRODUCT")
public class Product extends BaseEntity {

    private static final int MIN_NAME_LENGTH = 5;
    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_DESCRIPTION_LENGTH = 200;
    private static final int MAX_SPECIFICATION_LENGTH = 250;

    @NotBlank
    @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH)
    @Column(name = "NAME", nullable = false, length = MAX_NAME_LENGTH)
    private String name;

    @Size(max = MAX_NAME_LENGTH)
    @Column(name = "DESCRIPTION", length = MAX_DESCRIPTION_LENGTH)
    private String description;

    @Size(max = MAX_SPECIFICATION_LENGTH)
    @Column(name = "SPECIFICATIONS", length = MAX_SPECIFICATION_LENGTH)
    private String specifications;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    @Column(name = "CATEGORIES")
    private Set<Category> categories;

    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID")
    private Manufacturer manufacturer;

    protected Product() {
        // An no argument constructor is required by JPA specification
    }

    public Product(@NotBlank @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH) String name,
                   @Size(max = MAX_NAME_LENGTH) String description,
                   String specifications, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.specifications = specifications;
        this.price = price;
        this.categories = new HashSet<>(2);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
    }

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

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getName(), getDescription(), getSpecifications(),
                getPrice(), getCategories(), getManufacturer());
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;

        Product product = (Product) obj;
        return Objects.equals(getName(), product.getName()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getSpecifications(), product.getSpecifications()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getCategories(), product.getCategories()) &&
                Objects.equals(getManufacturer(), product.getManufacturer());
    }
}
