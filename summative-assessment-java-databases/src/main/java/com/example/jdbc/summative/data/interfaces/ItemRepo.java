package com.example.jdbc.summative.data.interfaces;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.model.Item;
import com.example.jdbc.summative.model.ItemCategory;

import java.time.LocalDate;
import java.util.List;

public interface ItemRepo {
    Item getItemById(int id) throws RecordNotFoundException, InternalErrorException;

    // Item records have a StartDate and an EndDate.
    // Return only the records where the given date falls in between the StartDate and EndDate inclusive.
    List<Item> getAllAvailableItems(LocalDate today) throws InternalErrorException;
    List<Item> getItemsByCategory(LocalDate today, int itemCategoryID) throws InternalErrorException;

    //ItemCategory being used only in context with the Item table, this method has been bundled within the Item repo
    List<ItemCategory> getAllItemCategories() throws InternalErrorException;
}
