package com.example.jdbc.summative.data.interfaces;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.model.PaymentType;

import java.util.List;

public interface PaymentTypeRepo {
    List<PaymentType> getAll() throws InternalErrorException;
}
