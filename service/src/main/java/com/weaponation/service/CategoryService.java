package com.weaponation.service;

import com.weaponation.domain.Category;
import com.weaponation.repository.CategoryRepository;

import org.springframework.stereotype.Service;

/**
 * @author Wallison Freitas
 */
@Service
public class CategoryService extends EntityService<Category> {

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
