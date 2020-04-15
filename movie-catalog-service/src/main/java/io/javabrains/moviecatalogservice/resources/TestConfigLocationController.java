package io.javabrains.moviecatalogservice.resources;

import org.bouncycastle.asn1.pkcs.SafeBag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestConfigLocationController {
    
    private static final Logger LOG = LoggerFactory.getLogger(TestConfigLocationController.class);
    
    @Value("${test.config.location}")
    private String testConfigLocation;
    
    @GetMapping("/configLocation")
    public String getTestConfigLocation(){
        LOG.info("Testing the location of config file for movie-catalog-service");
        return testConfigLocation;
    }
    
}


