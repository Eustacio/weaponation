package com.weaponation.testUtil;

import com.weaponation.core.config.RootApplicationContext;
import com.weaponation.core.settings.Profile;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Wallison Freitas
 */
@ActiveProfiles(Profile.INTEGRATION_TEST)
@SpringJUnitConfig(RootApplicationContext.class)
@Transactional
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IntegrationTest {}
