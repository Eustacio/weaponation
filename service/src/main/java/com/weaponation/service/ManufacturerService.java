package com.weaponation.service;

import com.weaponation.domain.Manufacturer;
import com.weaponation.exception.DuplicateEntityException;
import com.weaponation.exception.EntityNotFoundException;
import com.weaponation.repository.ManufacturerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        Manufacturer savedManufacturer;

        try {
            savedManufacturer = super.repository.save(manufacturer);
        } catch (DataIntegrityViolationException dataIntegrityException) {
            throw new DuplicateEntityException("Cannot save the manufacturer '" + manufacturer.getName() +
                    "' because it already exists!", dataIntegrityException);
        }

        return savedManufacturer;
    }

    @Override
    public boolean delete(Long id) {
        try {
            super.repository.deleteById(id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new EntityNotFoundException("Cannot delete the Manufacturer with id '" + id +
                    "' because it does not exists", emptyResultDataAccessException);
        }

        return !super.repository.existsById(id);
    }
}
