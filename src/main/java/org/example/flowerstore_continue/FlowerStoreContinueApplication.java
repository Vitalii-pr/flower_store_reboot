package org.example.flowerstore_continue;

import org.example.flowerstore_continue.flowerStore.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import org.example.flowerstore_continue.flowerStore.Flower;
import org.example.flowerstore_continue.flowerStore.FlowerColor;
import org.example.flowerstore_continue.flowerStore.FlowerType;



@SpringBootApplication
@RestController
public class FlowerStoreContinueApplication {

    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerStoreContinueApplication(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FlowerStoreContinueApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedData() {
        return args -> {
            if (flowerRepository.count() == 0) {
                flowerRepository.save(new Flower(2.5, FlowerColor.BLUE, 10, FlowerType.TULIP));
                flowerRepository.save(new Flower(3.5, FlowerColor.RED, 10, FlowerType.ROSE));

                System.out.println("Sample data seeded.");
            } else {
                System.out.println("Data already exists. Skipping seeding.");
            }
        };
    }
}
