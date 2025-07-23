package com.example.jdbc.summative.data.interfaces;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.model.Tax;

import java.time.LocalDate;

public interface TaxRepo {
    // Tax records have a StartDate and an EndDate.
    // Return only the records where the given date falls in between the StartDate and EndDate inclusive.
    public Tax getCurrentTax(LocalDate dateOf) throws InternalErrorException, RecordNotFoundException;
}
