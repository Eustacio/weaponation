package com.weaponation.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Wallison Freitas
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.weaponation.web")
public class WebApplicationContext {}
