package com.weaponation.service;

import com.weaponation.domain.Category;
import com.weaponation.domain.Manufacturer;
import com.weaponation.domain.Product;
import com.weaponation.exception.DuplicateEntityException;
import com.weaponation.exception.EntityNotFoundException;
import com.weaponation.testUtil.IntegrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author Wallison Freitas
 */
@IntegrationTest
class CategoryServiceIT {

    @Autowired
    private CategoryService service;

    @Autowired
    private ManufacturerService manufacturerService;

    @Test
    @DisplayName("save() should accept new Category without products")
    void save_ShouldAcceptNewCategory_WithoutProducts() {
        final String categoryName = "weapons";
        final Category newCategory = new Category(categoryName);

        final Category savedCategory = service.save(newCategory);

        assertThat(savedCategory).isNotNull();
        assertThat(savedCategory.getId()).isPositive();
        assertThat(savedCategory.getName()).isEqualTo(categoryName);
        assertThat(savedCategory.getProducts()).isEmpty();
    }

    @Test
    @DisplayName("save() should accept new Category with products")
    void save_ShouldAcceptNewCategory_WithProducts() {
        Product product1 = new Product("Product 1", "Product 1 description", "no specs", BigDecimal.ONE);
        Product product2 = new Product("Product 2", "Product 2 description", "no specs", BigDecimal.TEN);

        Manufacturer manufacturer = new Manufacturer("ACME");
        manufacturer.addProducts(product1, product2);
        manufacturerService.save(manufacturer);

        final String categoryName = "weapons";
        Category newCategory = new Category(categoryName);
        newCategory.addProducts(product1, product2);


        final Category savedCategory = service.save(newCategory);

        assertThat(savedCategory).isNotNull();
        assertThat(savedCategory.getId()).isPositive();
        assertThat(savedCategory.getName()).isEqualTo(categoryName);
        assertThat(savedCategory.getProducts()).containsExactlyInAnyOrder(product1, product2);
    }

    @Test
    @DisplayName("save() should throw DuplicateEntityException when Category name already exists")
    void save_ShouldThrow_DuplicateEntityException_WhenCategoryNameAlreadyExists() {
        final String categoryName = "weapons";
        final Category newCategory = new Category(categoryName);
        final Category anotherCategory = new Category(categoryName);

        service.save(newCategory);

        assertThatExceptionOfType(DuplicateEntityException.class)
                .isThrownBy(() -> service.save(anotherCategory));
    }

    @Test
    void delete() {
        final String categoryName = "weapons";
        final Category newCategory = new Category(categoryName);
        service.save(newCategory);
        final Long savedCategoryId = newCategory.getId();

        final boolean wasDeleted = service.delete(savedCategoryId);

        assertThat(wasDeleted).isTrue();
        assertThat(service.findById(savedCategoryId)).isEmpty();
    }

    @Test
    @DisplayName("delete() should throw EntityNotFoundException when Category not exists")
    void delete_ShouldThrow_EntityNotFoundException_WhenManufacturerNotExists() {
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> service.delete(666L));
    }
}
