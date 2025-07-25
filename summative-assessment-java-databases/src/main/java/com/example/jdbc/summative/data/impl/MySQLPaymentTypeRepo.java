package com.example.jdbc.summative.data.impl;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.interfaces.PaymentTypeRepo;
import com.example.jdbc.summative.model.PaymentType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySQLPaymentTypeRepo implements PaymentTypeRepo {
    @Override
    public List<PaymentType> getAll() throws InternalErrorException {
        return List.of();
    }
}
