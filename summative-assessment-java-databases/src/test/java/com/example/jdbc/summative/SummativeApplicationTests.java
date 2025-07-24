package com.example.jdbc.summative;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.data.interfaces.OrderRepo;
import com.example.jdbc.summative.model.Order;
import com.example.jdbc.summative.service.BistroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SummativeApplicationTests {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private BistroService svc;

	@Test
	void testCalculateOrderTotals() throws RecordNotFoundException, InternalErrorException {
		Order expected = orderRepo.getOrderById(1);
		Order actual = orderRepo.getOrderById(1);

		svc.calculateOrderTotals(actual);
		assertEquals(expected, actual);
	}
}
