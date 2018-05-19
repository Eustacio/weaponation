package com.weaponation.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wallison Freitas
 */
class ManufacturerTest {

    @Test
    @DisplayName("equals() and hashCode() contract")
    void equalsAndHashCodeContract() {
        EqualsVerifier.forClass(Manufacturer.class)
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
