package com.weaponation.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wallison Freitas
 */
class CategoryTest {

    @Test
    @DisplayName("equals() and hashCode() contract")
    void equalsAndHashCodeContract() {
        EqualsVerifier.forClass(Category.class)
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