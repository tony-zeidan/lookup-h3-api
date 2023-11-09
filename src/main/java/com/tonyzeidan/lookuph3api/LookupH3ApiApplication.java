package com.tonyzeidan.lookuph3api;

import com.tonyzeidan.lookuph3api.controllers.LookupH3Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class LookupH3ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LookupH3ApiApplication.class, args);
    }

}
