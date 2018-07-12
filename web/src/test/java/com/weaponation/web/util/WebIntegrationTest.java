package com.weaponation.web.util;

import com.weaponation.core.config.RootApplicationContext;
import com.weaponation.core.settings.Profiles;
import com.weaponation.web.config.WebApplicationContext;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Wallison Freitas
 */
@Transactional
@ActiveProfiles(Profiles.INTEGRATION_TEST)
@SpringJUnitWebConfig(classes = {RootApplicationContext.class, WebApplicationContext.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebIntegrationTest {}
