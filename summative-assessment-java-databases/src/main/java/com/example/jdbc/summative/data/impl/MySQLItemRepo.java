package com.example.jdbc.summative.data.impl;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.data.interfaces.ItemRepo;
import com.example.jdbc.summative.data.mappers.ItemCategoryRowMapper;
import com.example.jdbc.summative.data.mappers.ItemRowMapper;
import com.example.jdbc.summative.model.Item;
import com.example.jdbc.summative.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MySQLItemRepo implements ItemRepo {

    private final JdbcTemplate jdbcTemplate;
    private final ItemRowMapper itemRowMapper = new ItemRowMapper();
    private final ItemCategoryRowMapper itemCategoryRowMapper = new ItemCategoryRowMapper();


    @Autowired
    public MySQLItemRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Item getItemById(int id) throws RecordNotFoundException, InternalErrorException {
        String sql = """
        SELECT * FROM item
        WHERE ItemID = ?
        """;
        try {
            List<Item> items = jdbcTemplate.query(sql, itemRowMapper, id);

            if (items.isEmpty()) {
                throw new RecordNotFoundException("Item with ID " + id + " not found.");
            }

            return items.get(0);
        } catch (DataAccessException ex) {
            throw new InternalErrorException("Failed to get item by ID: " + id, ex);
        }

    }

    @Override
    public List<Item> getAllAvailableItems(LocalDate today) throws InternalErrorException {
        try {
            // SQL query to select items active on the given date
            String sql = """
            SELECT * FROM Item
            WHERE ? BETWEEN StartDate AND IFNULL(EndDate, '9999-12-31')
            ORDER BY ItemID;
        """;

            // Executes the query with the 'today' parameter mapped to LocalDate
            return jdbcTemplate.query(sql, itemRowMapper, today);

        } catch (DataAccessException ex) {
            // Wrap any database access exceptions into your InternalErrorException
            throw new InternalErrorException("Failed to get all available items", ex);
        }
    }

    @Override
    public List<Item> getItemsByCategory(LocalDate today, int itemCategoryID) throws InternalErrorException {
        try {
            String sql = """
            SELECT * FROM Item
            WHERE ? BETWEEN StartDate AND IFNULL(EndDate, '9999-12-31')
            AND ItemCategoryID = ?
            ORDER BY ItemID;
        """;

            return jdbcTemplate.query(sql, new ItemRowMapper(), today, itemCategoryID);

        } catch (DataAccessException ex) {
            throw new InternalErrorException("Failed to get items by category", ex);
        }
    }

    @Override
    public List<ItemCategory> getAllItemCategories() throws InternalErrorException {
        String sql = "SELECT * FROM ItemCategory ORDER BY ItemCategoryID";
        try {
            return jdbcTemplate.query(sql, itemCategoryRowMapper);
        } catch (DataAccessException ex) {
            throw new InternalErrorException("Failed to retrieve item categories", ex);
        }
    }
}