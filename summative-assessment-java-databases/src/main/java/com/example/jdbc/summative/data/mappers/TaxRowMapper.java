package com.example.jdbc.summative.data.mappers;

import com.example.jdbc.summative.model.Tax;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class TaxRowMapper implements RowMapper<Tax> {

    @Override
    public Tax mapRow(ResultSet rs, int numRow) throws SQLException {
        Tax tax = new Tax();

        tax.setTaxID(rs.getInt("TaxID"));
        tax.setTaxPercentage(rs.getBigDecimal("TaxPercentage"));
        tax.setStartDate(rs.getObject("StartDate", LocalDate.class));
        tax.setEndDate(rs.getObject("EndDate", LocalDate.class));

        return tax;
    }
}
