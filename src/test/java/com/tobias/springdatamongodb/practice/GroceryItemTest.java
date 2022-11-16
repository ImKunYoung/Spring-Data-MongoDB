package com.tobias.springdatamongodb.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GroceryItemTest {

    @Autowired
    private ItemRepository groceryItemRepo;

    @Test
    void createGroceryItems() {
        System.out.println("Data creation started...");
        groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
        System.out.println("Data creation complete...");
    }

    @Test
    public void showAllGroceryItems() { // 1. Show all the data
        groceryItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
    }
    @Test
    public void getGroceryItemByName(String name) { // 2. Get item by name
        System.out.println("Getting item by name: " + name);
        GroceryItem item = groceryItemRepo.findItemByName(name);
        System.out.println(getItemDetails(item));
    }
    @Test
    public void getItemsByCategory(String category) { // 3. Get name and quantity of a all items of a particular category
        System.out.println("Getting items for the category " + category);
        List<GroceryItem> list = groceryItemRepo.findAll(category);

        list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
    }
    @Test
    public void findCountOfGroceryItems() { // 4. Get count of documents in the collection
        long count = groceryItemRepo.count();
        System.out.println("Number of documents in the collection: " + count);
    }
    public String getItemDetails(GroceryItem item) { // Print details in readable form
        System.out.println("Item Name: " + item.getName() +
                ", \nQuantity: " + item.getQuantity() +
                ", \nItem Category: " + item.getCategory()
        );
        return "";
    }
}
