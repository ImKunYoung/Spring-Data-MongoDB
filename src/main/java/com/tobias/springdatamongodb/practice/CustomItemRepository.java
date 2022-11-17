package com.tobias.springdatamongodb.practice;


public interface CustomItemRepository {

    void updateItemQuantity(String name, int newQuantity);

}
