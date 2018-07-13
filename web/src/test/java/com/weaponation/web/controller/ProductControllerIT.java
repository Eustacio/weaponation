package com.weaponation.web.controller;

import com.weaponation.domain.Category;
import com.weaponation.domain.Manufacturer;
import com.weaponation.domain.Product;
import com.weaponation.service.ProductService;
import com.weaponation.web.util.WebIntegrationTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Wallison Freitas
 */
@WebIntegrationTest
class ProductControllerIT {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ProductService mockProductService;

    private MockMvc mockMvc;
    private List<Product> fakeProducts;

    @BeforeEach
    void beforeAllTests() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        createFakeProducts();
    }

    @Test
    void getAllProducts() throws Exception {
        when(mockProductService.findAll()).thenReturn(fakeProducts);

        ResultActions result = mockMvc.perform(get("/products").accept(MediaType.APPLICATION_JSON_UTF8));
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("length()", equalTo(fakeProducts.size())));

        for (int i = 0; i < fakeProducts.size(); i++) {
            final Product product = fakeProducts.get(i);
            final String path = "$.[" + i + "]";

            result.andExpect(jsonPath(path + ".name", is(equalTo(product.getName()))));
            result.andExpect(jsonPath(path + ".description", is(equalTo(product.getDescription()))));
            result.andExpect(jsonPath(path + ".specifications", is(equalTo(product.getSpecifications()))));
            result.andExpect(jsonPath(path + ".price", is(closeTo(product.getPrice(), BigDecimal.ZERO))));
            // result.andExpect(jsonPath(path + ".categories..name.*", containsInAnyOrder(product.getCategories().stream().map(Category::getName).toArray())));
            result.andExpect(jsonPath(path + ".manufacturer.name", is(product.getManufacturer().getName())));
        }
    }

    private void createFakeProducts() {
        final Manufacturer acme = new Manufacturer("ACME");
        Product product1 = new Product("AcmeAtomicBomb", "Blow up your problems (especially if your problem is the Road Runner)!", "", new BigDecimal(666666666.66));
        product1.addCategory(new Category("Explosive Devices"));
        product1.addCategory(new Category("Atomic Weapons"));
        product1.setManufacturer(acme);

        Product product2 = new Product("AcmeBarret .50", "Specially designed to shot Road Runner's at long distance!", "", new BigDecimal(12666.66));
        product2.addCategory(new Category("Rifles"));
        product2.setManufacturer(acme);

        fakeProducts = List.of(product1, product2);
    }

    /**
     * Provides a Mockito mock version to classes that are injected in this
     * file using the {@link Autowired} annotation.
     */
    @Configuration
    static class TestConfig {

        @Bean
        @Primary
        ProductService mockProductService() {
            return Mockito.mock(ProductService.class);
        }
    }
}
