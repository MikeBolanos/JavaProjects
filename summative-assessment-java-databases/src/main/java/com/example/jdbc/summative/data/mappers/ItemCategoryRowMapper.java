package com.example.jdbc.summative.data.mappers;

import com.example.jdbc.summative.model.ItemCategory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ItemCategoryRowMapper implements RowMapper<ItemCategory> {

    @Override
    public ItemCategory mapRow(ResultSet rs, int rowNum) throws SQLException {

        ItemCategory itemCategory = new ItemCategory();

        itemCategory.setItemCategoryID(rs.getInt("ItemCategoryID"));
        itemCategory.setItemCategoryName(rs.getString("ItemCategoryName"));

        return itemCategory;
    }
}
