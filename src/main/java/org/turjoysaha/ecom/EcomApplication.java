package org.turjoysaha.ecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.turjoysaha.ecom.services.InitService;

@SpringBootApplication
public class EcomApplication  implements CommandLineRunner {

    @Autowired
    private InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(EcomApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initService.initialize();
    }

}
