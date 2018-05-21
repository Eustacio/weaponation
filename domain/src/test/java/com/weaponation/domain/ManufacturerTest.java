package com.weaponation.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wallison Freitas
 */
class ManufacturerTest {

    @Test
    @DisplayName("equals() and hashCode() contract")
    void equalsAndHashCodeContract() {
        final Product dummyProduct1 = new Product("someProduct",
                "my creativity is not helping me today ;)", "some specification", BigDecimal.ZERO);

        final Product dummyProduct2 = new Product("anotherProduct",
                "another description", "some specification", BigDecimal.ONE);

        EqualsVerifier.forClass(Manufacturer.class)
                // Add prefab values to avoid java.lang.AssertionError: Recursive datastructure.
                // To More info check http://jqno.nl/equalsverifier/errormessages/recursive-datastructure/
                .withPrefabValues(Product.class, dummyProduct1, dummyProduct2)

                // The "name" field is the only field that is used in equals() and hashCode() methods
                .withOnlyTheseFields("name")
                .verify();
    }

    @Test
    @DisplayName("toString() should return the manufacturer name when is called")
    void toString_ShouldReturnTheManufacturerName_WhenIsCalled() {
        final String manufacturerName = "Someone";

        Manufacturer manufacturer = new Manufacturer(manufacturerName);

        assertThat(manufacturer.toString())
                .isEqualTo(manufacturerName);
    }
}
