package com.weaponation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Wallison Freitas
 */
@Entity
@Table(name = "IMAGE")
public class Image extends BaseEntity {

    @Column(name = "SMALL_SIZE_IMAGE")
    private String smallSizeImage;

    @Column(name = "MEDIUM_SIZE_IMAGE")
    private String mediumSizeImage;

    @Column(name = "LARGE_SIZE_IMAGE")
    private String largeSizeImage;

    @Column(name = "DESCRIPTION")
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "IMAGE_PRODUCT",
            joinColumns = @JoinColumn(name = "IMAGE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private Product product;

    protected Image() {
        // An no argument constructor is required by JPA specification
    }

    public Image(String smallSizeImage, String mediumSizeImage, String largeSizeImage) {
        this.smallSizeImage = smallSizeImage;
        this.mediumSizeImage = mediumSizeImage;
        this.largeSizeImage = largeSizeImage;
    }

    public void addProduct(Product product) {
        Objects.requireNonNull(product, "Product must be not null!");
        product.addImage(this);
        this.product = product;
    }

    public void removeProduct(Product product) {
        Objects.requireNonNull(product, "Product must be not null!");
        product.removeImage(this);
        this.product = null;
    }

    public String getSmallSizeImage() {
        return smallSizeImage;
    }

    public void setSmallSizeImage(String smallSizeImage) {
        this.smallSizeImage = smallSizeImage;
    }

    public String getMediumSizeImage() {
        return mediumSizeImage;
    }

    public void setMediumSizeImage(String mediumSizeImage) {
        this.mediumSizeImage = mediumSizeImage;
    }

    public String getLargeSizeImage() {
        return largeSizeImage;
    }

    public void setLargeSizeImage(String largeSizeImage) {
        this.largeSizeImage = largeSizeImage;
    }

    public Product getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSmallSizeImage(), getMediumSizeImage(), getLargeSizeImage());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Image)) return false;

        Image image = (Image) obj;
        return Objects.equals(getSmallSizeImage(), image.getSmallSizeImage()) &&
                Objects.equals(getMediumSizeImage(), image.getMediumSizeImage()) &&
                Objects.equals(getLargeSizeImage(), image.getLargeSizeImage());
    }
}
