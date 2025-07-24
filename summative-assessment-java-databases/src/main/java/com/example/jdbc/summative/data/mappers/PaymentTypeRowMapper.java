package com.example.jdbc.summative.data.mappers;

import com.example.jdbc.summative.model.PaymentType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PaymentTypeRowMapper implements RowMapper<PaymentType> {
    public PaymentType mapRow(ResultSet rs, int rowNum) throws SQLException {
        PaymentType paymentType = new PaymentType();

        paymentType.setPaymentTypeID(rs.getInt("PaymentTypeID"));
        paymentType.setPaymentTypeName(rs.getString("PaymentTypeName"));

        return paymentType;
    }
}
