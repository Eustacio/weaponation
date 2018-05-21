package com.weaponation.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wallison Freitas
 */
class CategoryTest {

    @Test
    @DisplayName("equals() and hashCode() contract")
    void equalsAndHashCodeContract() {
        final Product dummyProduct1 = new Product("someProduct",
                "some description", "some specification", BigDecimal.ZERO);

        final Product dummyProduct2 = new Product("anotherProduct",
                "another description", "some specification", BigDecimal.ONE);

        EqualsVerifier.forClass(Category.class)
                // Add prefab values to avoid java.lang.AssertionError: Recursive datastructure.
                // To More info check http://jqno.nl/equalsverifier/errormessages/recursive-datastructure/
                .withPrefabValues(Product.class, dummyProduct1, dummyProduct2)

                // The "name" field is the only field that is used in equals() and hashCode() methods
                .withOnlyTheseFields("name")
                .verify();
    }

    @Test
    @DisplayName("toString() should return the category name when is called")
    void toString_ShouldReturnTheCategoryName_WhenIsCalled() {
        final String categoryName = "ammunition";

        Category category = new Category(categoryName);

        assertThat(category.toString())
                .isEqualTo(categoryName);
    }
}