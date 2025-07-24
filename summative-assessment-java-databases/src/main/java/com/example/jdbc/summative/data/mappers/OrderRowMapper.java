package com.example.jdbc.summative.data.mappers;

import com.example.jdbc.summative.model.Order;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class OrderRowMapper implements RowMapper<Order> {

    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();

        order.setOrderID(rs.getInt("OrderID"));
        order.setServerID(rs.getInt("ServerID"));
        order.setOrderDate(rs.getObject("OrderDate", LocalDateTime.class));
        order.setSubTotal(rs.getBigDecimal("SubTotal"));
        order.setTax(rs.getBigDecimal("Tax"));
        order.setTip(rs.getBigDecimal("Tip"));
        order.setTotal(rs.getBigDecimal("Total"));

        return order;
    }
}
