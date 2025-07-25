package com.example.jdbc.summative.data.impl;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.data.interfaces.TaxRepo;
import com.example.jdbc.summative.data.mappers.TaxRowMapper;
import com.example.jdbc.summative.model.Tax;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public class MySQLTaxRepo implements TaxRepo {
    private final JdbcTemplate jdbcTemplate;
    private final TaxRowMapper taxRowMapper = new TaxRowMapper();

    public MySQLTaxRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tax getCurrentTax(LocalDate dateOf) throws InternalErrorException, RecordNotFoundException {
        String sql = """
            SELECT * FROM Tax
            WHERE ? BETWEEN StartDate AND IFNULL(EndDate, '9999-12-31')
            """;

        try {
            return jdbcTemplate.queryForObject(sql, taxRowMapper, dateOf);
        } catch (EmptyResultDataAccessException ex) {
            throw new RecordNotFoundException("No tax found for date: " + dateOf, ex);
        } catch (DataAccessException ex) {
            throw new InternalErrorException("Failed to retrieve tax record", ex);
        }
    }
}
