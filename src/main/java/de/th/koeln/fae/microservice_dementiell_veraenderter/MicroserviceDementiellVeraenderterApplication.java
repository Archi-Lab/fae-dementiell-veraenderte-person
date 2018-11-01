package de.th.koeln.fae.microservice_dementiell_veraenderter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MicroserviceDementiellVeraenderterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDementiellVeraenderterApplication.class, args);
    }
}
