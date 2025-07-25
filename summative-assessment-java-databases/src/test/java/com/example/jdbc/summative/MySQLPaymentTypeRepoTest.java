package com.example.jdbc.summative;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.impl.MySQLPaymentTypeRepo;
import com.example.jdbc.summative.model.PaymentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Sql("/sql/reset_db.sql")
public class MySQLPaymentTypeRepoTest {

    @Autowired
    private MySQLPaymentTypeRepo paymentTypeRepo;

    @Test
    public void testGetAllReturnsAllPaymentTypes() throws InternalErrorException {
        List<PaymentType> types = paymentTypeRepo.getAll();

        assertNotNull(types, "Returned list should not be null");
        assertFalse(types.isEmpty(), "Returned list should not be empty");
    }

    @Test
    public void testGetAllReturnsAllPaymentTypesWithExpectedValues () throws InternalErrorException {
        List<PaymentType> types = paymentTypeRepo.getAll();

        // Assert expected values
            PaymentType first = types.get(0);
            assertNotNull(first.getPaymentTypeID(), "First payment type ID should not be null");
            assertNotNull(first.getPaymentTypeName(), "First payment type name should not be null");
    }
}
