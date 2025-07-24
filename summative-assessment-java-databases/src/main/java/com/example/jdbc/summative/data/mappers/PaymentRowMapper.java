package com.example.jdbc.summative.data.mappers;

import com.example.jdbc.summative.model.Payment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PaymentRowMapper implements RowMapper<Payment> {

    @Override

    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Payment payment = new Payment();

        payment.setPaymentID(rs.getInt("PaymentID"));
        payment.setPaymentTypeID(rs.getInt("PaymentTypeID"));
        payment.setOrderID(rs.getInt("OrderID"));
        payment.setAmount(rs.getBigDecimal("Amount"));

        return payment;
    }
}