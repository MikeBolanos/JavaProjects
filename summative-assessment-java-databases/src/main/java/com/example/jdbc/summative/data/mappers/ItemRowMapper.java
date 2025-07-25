package com.example.jdbc.summative.data.mappers;

import com.example.jdbc.summative.model.Item;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


@Component
public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();

        item.setItemID(rs.getInt("ItemID"));
        item.setItemCategoryID(rs.getInt("itemCategoryID"));
        item.setItemName(rs.getString("ItemName"));
        item.setItemDescription(rs.getString("ItemDescription"));
        item.setStartDate(rs.getObject("StartDate", LocalDate.class));
        item.setEndDate(rs.getObject("EndDate", LocalDate.class));
        item.setUnitPrice(rs.getBigDecimal("UnitPrice"));

        return item;
    }
}
