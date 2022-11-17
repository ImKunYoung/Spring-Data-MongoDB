package com.tobias.springdatamongodb.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomItemRepositoryTest {

    @Autowired
    CustomItemRepository customRepo;

    // UPDATE
    @Test
    public void updateItemQuantity() {
        System.out.println("\n-----------UPDATE QUANTITY OF A GROCERY ITEM------------------------\n");

        String name = "XYZ Kodo Millet healthy";
        int newQuantity = 10;

        System.out.println("Updating quantity for " + name);
        customRepo.updateItemQuantity(name, newQuantity);
    }

}
