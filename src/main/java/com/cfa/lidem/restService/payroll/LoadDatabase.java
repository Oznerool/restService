package com.cfa.lidem.restService.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDataBase(EmployeRepository repository){
        return args -> {
            log.info("preloading => " + repository.save(new Employe("Bilbo Baggind", "burglar")));
            log.info("preloading => " + repository.save(new Employe("Froddo Baggind", "burglar")));
        };
    }
}
