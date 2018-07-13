package com.weaponation.web.controller;

import com.weaponation.domain.Product;
import com.weaponation.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Wallison Freitas
 */
@RestController
@RequestMapping(path = "products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<Product> productList = productService.findAll();
        if (productList.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(productList);
    }
}
