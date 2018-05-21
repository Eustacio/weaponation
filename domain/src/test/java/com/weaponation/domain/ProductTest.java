package com.weaponation.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * @author Wallison Freitas
 */
class ProductTest {

    @Test
    @DisplayName("equals() and hashCode() contract")
    void equalsAndHashCodeContract() {
        final Category dummyCategory1 = new Category("someCategory");
        final Category dummyCategory2 = new Category("anotherCategory");

        final Manufacturer dummyManufacturer1 = new Manufacturer("someManufacturer");
        final Manufacturer dummyManufacturer2 = new Manufacturer("anotherManufacturer");

        EqualsVerifier.forClass(Product.class)
                // Add prefab values to avoid java.lang.AssertionError: Recursive datastructure.
                // To More info check http://jqno.nl/equalsverifier/errormessages/recursive-datastructure/
                .withPrefabValues(Category.class, dummyCategory1, dummyCategory2)
                .withPrefabValues(Manufacturer.class, dummyManufacturer1, dummyManufacturer2)

                // The "id" field is never used in equals() and hashCode() methods so, ignore it
                .withIgnoredFields("id")
                .verify();
    }
}
