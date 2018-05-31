package com.weaponation.service;

import com.weaponation.domain.Product;
import com.weaponation.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wallison Freitas
 */
@Service
public class ProductService extends EntityService<Product> {

    @Autowired
    public ProductService(ProductRepository repository) {
        super(repository);
    }
}
