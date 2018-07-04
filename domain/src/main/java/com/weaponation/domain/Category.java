package com.weaponation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Wallison Freitas
 */
@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity {

    private static final int MIN_NAME_LENGTH = 5;
    private static final int MAX_NAME_LENGTH = 20;

    @NotBlank
    @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH)
    @Column(name = "NAME", unique = true, nullable = false, length = MAX_NAME_LENGTH)
    private String name;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "CATEGORY_PRODUCT",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
    )
    private Set<Product> products;

    protected Category() {
        // An no argument constructor is required by JPA specification
    }

    public Category(@NotBlank String name) {
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
        product.addCategory(this);
        products.add(product);
    }

    public void removeProduct(Product product) {
        Objects.requireNonNull(product, "Product must be not null!");
        product.removeCategory(this);
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
        if (!(obj instanceof Category)) return false;

        Category that = (Category) obj;
        return this.getName() == null ? that.getName() == null :
                this.getName().equalsIgnoreCase(that.getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}
