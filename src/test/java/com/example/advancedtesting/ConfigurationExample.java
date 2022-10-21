package com.example.advancedtesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConfigurationExample {

    private final SomeInterface someInterface;

    @Autowired
    public ConfigurationExample(SomeInterface someInterface) {
        this.someInterface = someInterface;
    }

    @Test
    void testSomeInterface() {
        String text = someInterface.text();
        assertThat(text).isEqualTo("test");
    }

    protected interface SomeInterface {

        String text();
    }

    @TestConfiguration
    protected static class MyTestConfiguration {

        @Bean
        public SomeInterface someInterface() {
            return () -> "test";
        }
    }
}
