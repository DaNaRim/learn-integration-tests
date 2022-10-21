package com.example.advancedtesting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceImplIntegrationTest {

    private final ProductServiceImpl productService;

    @MockBean
    private CurrencyConvertor currencyConvertor;

    @Autowired
    public ProductServiceImplIntegrationTest(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Test
    void productServiceImplIsNotNull() {
        assertThat(productService).isNotNull();
    }

}
