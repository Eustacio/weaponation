package com.weaponation.service;

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
class ManufacturerServiceIT {

    @Autowired
    private ManufacturerService service;

    @Test
    void save() {
        final Product product1 = new Product("Product 1", "Product 1 description", "no specs", BigDecimal.ONE);
        final Product product2 = new Product("Product 2", "Product 2 description", "no specs", BigDecimal.TEN);
        final String manufacturerName = "ACME";

        Manufacturer newManufacturer = new Manufacturer(manufacturerName);
        newManufacturer.addProducts(product1, product2);

        final Manufacturer savedManufacturer = service.save(newManufacturer);

        assertThat(savedManufacturer).isNotNull();
        assertThat(savedManufacturer.getId()).isPositive();
        assertThat(savedManufacturer.getName()).isEqualTo(manufacturerName);
        assertThat(savedManufacturer.getProducts()).containsExactlyInAnyOrder(product1, product2);
    }

    @Test
    @DisplayName("save() should throw DuplicateEntityException when Manufacturer name already exists")
    void save_ShouldThrow_DuplicateEntityException_WhenManufacturerNameAlreadyExists() {
        final String manufacturerName = "ACME";
        final Manufacturer newManufacturer = new Manufacturer(manufacturerName);
        final Manufacturer anotherManufacturer = new Manufacturer(manufacturerName);

        service.save(newManufacturer);

        assertThatExceptionOfType(DuplicateEntityException.class)
                .isThrownBy(() -> service.save(anotherManufacturer));
    }

    @Test
    void delete() {
        final String manufacturerName = "ACME";
        final Manufacturer newManufacturer = new Manufacturer(manufacturerName);
        service.save(newManufacturer);
        final Long savedManufacturerId = newManufacturer.getId();

        final boolean wasDeleted = service.delete(savedManufacturerId);

        assertThat(wasDeleted).isTrue();
        assertThat(service.findById(savedManufacturerId)).isEmpty();
    }

    @Test
    @DisplayName("delete() should throw EntityNotFoundException when Manufacturer not exists")
    void delete_ShouldThrow_EntityNotFoundException_WhenManufacturerNotExists() {
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> service.delete(666L));
    }
}
