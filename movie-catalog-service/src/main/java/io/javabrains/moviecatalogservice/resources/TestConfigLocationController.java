package io.javabrains.moviecatalogservice.resources;

import org.bouncycastle.asn1.pkcs.SafeBag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfigLocationController {
    
    @Value("${test.config.location}")
    private String testConfigLocation;
    
    @GetMapping("/configLocation")
    public String getTestConfigLocation(){
        return testConfigLocation;
    }
    
}


