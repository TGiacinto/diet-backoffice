package com.diet.dietbackoffice;

import com.diet.dietbackoffice.model.Test;
import com.diet.dietbackoffice.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class DietBackofficeApplication implements CommandLineRunner {

    public static void main(String[] args) {

        Path path = Paths.get("/diet-backoffice");
        if(!Files.exists(path)){

            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }


        }

        SpringApplication.run(DietBackofficeApplication.class, args);
    }

    @Autowired
    private TestRepository testRepository;

    @Override
    public void run(String... args) throws Exception {

        testRepository.save(Test.builder()
                        .name("XXXX")
                .build());


        testRepository.findAll().forEach(System.out::println);

    }
}
