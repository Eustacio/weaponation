package com.weaponation.service;

import com.weaponation.domain.Manufacturer;
import com.weaponation.repository.ManufacturerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wallison Freitas
 */
@Service
public class ManufacturerService extends EntityService<Manufacturer> {

    @Autowired
    public ManufacturerService(ManufacturerRepository repository) {
        super(repository);
    }
}
