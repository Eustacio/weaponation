package com.weaponation.service;

import com.weaponation.domain.Category;
import com.weaponation.exception.DuplicateEntityException;
import com.weaponation.exception.EntityNotFoundException;
import com.weaponation.repository.CategoryRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author Wallison Freitas
 */
@Service
public class CategoryService extends EntityService<Category> {

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public Category save(Category category) {
        Category savedCategory;

        try {
            savedCategory = super.repository.save(category);
        } catch (DataIntegrityViolationException dataIntegrityException) {
            throw new DuplicateEntityException("Cannot save the Category '" + category.getName() +
                    "' because it already exists!", dataIntegrityException);
        }

        return savedCategory;
    }

    @Override
    public boolean delete(Long id) {
        try {
            super.repository.deleteById(id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new EntityNotFoundException("Cannot delete the Category with id '" + id +
                    "' because it does not exists!", emptyResultDataAccessException);
        }

        return !super.repository.existsById(id);
    }
}
