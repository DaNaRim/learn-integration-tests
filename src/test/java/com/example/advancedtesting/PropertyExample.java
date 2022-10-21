package com.example.advancedtesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test1")
@TestPropertySource("classpath:some-test.properties")
@TestPropertySource(properties = "propertyFromAnnotation=3")
class PropertyExample {

    @Value("${my-property}")
    private String myProperty;

    @Value("${some-test-property}")
    private String someTestProperty;

    @Value("${property-from-annotation}")
    private String propertyFromAnnotation;

    @Test
    void testMyProperty() {
        assertThat(myProperty).isEqualTo("1");
    }

    @Test
    void testOtherTestProperty() {
        assertThat(someTestProperty).isEqualTo("2");
    }

    @Test
    void testPropertyFromAnnotation() {
        assertThat(propertyFromAnnotation).isEqualTo("3");
    }

}
