package com.example.jdbc.summative.data.impl;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.interfaces.PaymentTypeRepo;
import com.example.jdbc.summative.data.mappers.PaymentTypeRowMapper;
import com.example.jdbc.summative.model.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySQLPaymentTypeRepo implements PaymentTypeRepo {

    private final JdbcTemplate jdbcTemplate;
    private final PaymentTypeRowMapper paymentTypeRowMapper = new PaymentTypeRowMapper();

    @Autowired
    public MySQLPaymentTypeRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PaymentType> getAll() throws InternalErrorException {
        String sql = """
            SELECT * FROM PaymentType 
            ORDER BY PaymentTypeID
        """;

        try {
            return jdbcTemplate.query(sql, paymentTypeRowMapper);
        } catch (DataAccessException ex) {
            throw new InternalErrorException("Failed to fetch all payment types.", ex);
        }
    }
}
