package com.example.jdbc.summative.data.impl;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.data.interfaces.TaxRepo;
import com.example.jdbc.summative.model.Tax;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public class MySQLTaxRepo implements TaxRepo {
    @Override
    public Tax getCurrentTax(LocalDate dateOf) throws InternalErrorException, RecordNotFoundException {
        return null;
    }
}
