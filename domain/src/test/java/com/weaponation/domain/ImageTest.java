package com.weaponation.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * @author Wallison Freitas
 */
class ImageTest {

    @Test
    @DisplayName("equals() and hashCode() contract")
    void equalsAndHashCodeContract() {
        EqualsVerifier.forClass(Image.class)
                .withIgnoredFields("id")
                .verify();
    }
}
