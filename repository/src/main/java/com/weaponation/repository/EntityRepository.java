package com.weaponation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Wallison Freitas
 */
@NoRepositoryBean
public interface EntityRepository<T> extends JpaRepository<T, Long> {}
