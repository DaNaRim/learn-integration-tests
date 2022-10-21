package com.example.advancedtesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(ConfigurationExample.MyTestConfiguration.class)
class ImportExample {

    private final ConfigurationExample.SomeInterface someInterface;

    @Autowired
    public ImportExample(ConfigurationExample.SomeInterface someInterface) {
        this.someInterface = someInterface;
    }

    @Test
    void testSomeInterface() {
        String text = someInterface.text();
        assertThat(text).isEqualTo("test");
    }

}
