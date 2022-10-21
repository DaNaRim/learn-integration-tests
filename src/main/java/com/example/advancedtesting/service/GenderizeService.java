package com.example.advancedtesting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class GenderizeService implements GenderService {

    @Value("${genderize.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getGender(String name) {
        GenderizeResponse response = restTemplate.getForObject(url, GenderizeResponse.class,
                Collections.singletonMap("name", name));
        if (response == null) {
            return null;
        }
        return response.getGender();
    }

}
