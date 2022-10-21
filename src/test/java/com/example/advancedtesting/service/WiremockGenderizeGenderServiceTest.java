package com.example.advancedtesting.service;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@WireMockTest(httpPort = 8080)
@TestPropertySource(properties = "genderize.url=http://localhost:8080/?name={name}")
class WiremockGenderizeGenderServiceTest {

    private final GenderizeService service;

    @Autowired
    public WiremockGenderizeGenderServiceTest(GenderizeService service) {
        this.service = service;
    }

    @Test
    void testGender(WireMockRuntimeInfo wmRuntimeInfo) {
        GenderizeResponse response = new GenderizeResponse();
        response.setName("Taras");
        response.setGender("male");
        stubFor(get("/?name=Taras").willReturn(jsonResponse(response, HttpStatus.OK.value())));

        // Other option
//        WireMock wireMock = wmRuntimeInfo.getWireMock();
//        wireMock.register(get("/?name=Taras").willReturn(jsonResponse(response, HttpStatus.OK.value())));
        String gender = service.getGender("Taras");

        assertThat(gender).isEqualTo("male");
    }

}
