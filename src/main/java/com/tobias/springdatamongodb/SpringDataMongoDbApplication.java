package com.tobias.springdatamongodb;

import com.tobias.springdatamongodb.practice.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@RequiredArgsConstructor
public class SpringDataMongoDbApplication {

    private final ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataMongoDbApplication.class, args);
    }

}
