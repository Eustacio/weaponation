package com.weaponation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

    @JsonIgnore
    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;

    protected Manufacturer() {
        // An no argument constructor is required by JPA specification
    }

    public Manufacturer(@NotBlank String name) {
        this.name = name;
        this.products = new HashSet<>();
    }

    public void addProducts(Product... products) {
        for (Product product : products) {
            this.addProduct(product);
        }
    }

    public void addProduct(Product product) {
        Objects.requireNonNull(product, "Product must be not null!");
        product.setManufacturer(this);
        products.add(product);
    }

    public void removeProduct(Product product) {
        Objects.requireNonNull(product, "Product must be not null!");
        product.setManufacturer(null);
        products.remove(product);
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return Set.copyOf(products);
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
