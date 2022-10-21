package com.example.advancedtesting.repository;

import com.example.advancedtesting.service.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    private final ProductRepository repository;

    @Autowired
    public ProductRepositoryTest(ProductRepository repository) {
        this.repository = repository;
    }

    @Test
    void testSave() {
        Product product = new Product();
        product.setName("My product 1");

        Product p = repository.save(product);

        assertThat(p.getId()).isEqualTo(1L);
    }

}
