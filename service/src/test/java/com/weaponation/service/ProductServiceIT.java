package com.weaponation.service;

import com.weaponation.domain.Manufacturer;
import com.weaponation.domain.Product;
import com.weaponation.exception.EntityNotFoundException;
import com.weaponation.testUtil.IntegrationTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author Wallison Freitas
 */
@IntegrationTest
class ProductServiceIT {

    @Autowired
    private ProductService service;

    @Autowired
    private ManufacturerService manufacturerService;

    @Test
    void save() {
        Product newProduct = new Product("some product", "some description", "specs", BigDecimal.ONE);

        Manufacturer manufacturer = new Manufacturer("ACME");
        manufacturer.addProduct(newProduct);
        manufacturerService.save(manufacturer);

        Product savedProduct = service.save(newProduct);

        assertThat(savedProduct.getId()).isPositive();
        assertThat(savedProduct).isEqualTo(newProduct);
    }

    @Test
    @Disabled("fix")
    void delete() {
        final Product newProduct = new Product("some product", "some description", "specs", BigDecimal.ONE);

        Manufacturer manufacturer = new Manufacturer("ACME");
        manufacturer.addProduct(newProduct);
        manufacturerService.save(manufacturer);

        final Product savedProduct = service.save(newProduct);
        final Long savedProductId = savedProduct.getId();

        final boolean wasDeleted = service.delete(savedProductId);

        assertThat(wasDeleted).isTrue();
        assertThat(service.findById(savedProductId)).isEmpty();
    }

    @Test
    @DisplayName("delete() should throw EntityNotFoundException when Product not exists")
    void delete_ShouldThrow_EntityNotFoundException_WhenManufacturerNotExists() {
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> service.delete(123L));
    }

    @Test
    void findById() {
        final Product newProduct = new Product("some product", "some description", "specs", BigDecimal.ONE);

        Manufacturer manufacturer = new Manufacturer("ACME");
        manufacturer.addProduct(newProduct);
        manufacturerService.save(manufacturer);

        final Product savedProduct = service.save(newProduct);
        final Long savedProductId = savedProduct.getId();

        Optional<Product> found = service.findById(savedProductId);

        assertThat(found).isNotEmpty();
        assertThat(found.get().getId()).isEqualTo(savedProduct.getId());
        assertThat(found.get()).isEqualTo(savedProduct);
    }

    @Test
    void findAll() {
        final Product product1 = new Product("some product", "some description", "specs", BigDecimal.ONE);
        final Product product2 = new Product("another product", "another description", "specs", BigDecimal.TEN);

        Manufacturer manufacturer = new Manufacturer("ACME");
        manufacturer.addProducts(product1, product2);
        manufacturerService.save(manufacturer);

        service.save(product1);
        service.save(product2);


        List<Product> productList = service.findAll();

        assertThat(productList).hasSize(2);
        assertThat(productList).containsExactlyInAnyOrder(product1, product2);
    }
}
