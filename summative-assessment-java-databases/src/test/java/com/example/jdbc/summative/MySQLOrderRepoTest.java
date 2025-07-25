package com.example.jdbc.summative;

import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.data.interfaces.OrderRepo;
import com.example.jdbc.summative.model.Order;
import com.example.jdbc.summative.model.OrderItem;
import com.example.jdbc.summative.model.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "/sql/reset_db.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class MySQLOrderRepoTest {
    @Autowired
    private OrderRepo orderRepo;

    @Test
    public void testGetOrderByIdWithValidIdReturnsOrder() throws Exception {
        Order order = orderRepo.getOrderById(1);
        assertNotNull(order);
        assertEquals(1, order.getOrderID());
        assertNotNull(order.getServer());
        assertFalse(order.getItems().isEmpty());
        assertFalse(order.getPayments().isEmpty());
    }

    @Test
    public void testGetOrderByIdWithInvalidId() {
        assertThrows(RecordNotFoundException.class, () -> {
            orderRepo.getOrderById(999);
        });
    }

    @Test
    public void testGetAllOrdersThatReturnsList() throws Exception {
        List<Order> orders = orderRepo.getAllOrders();
        assertNotNull(orders);
        assertFalse(orders.isEmpty());

        for (Order order : orders) {
            assertNotNull(order.getServer());
            assertNotNull(order.getItems());
            assertNotNull(order.getPayments());
        }
    }

    @Test
    public void testAddOrderInsertsOrderSuccessfully() throws Exception {
        Order order = new Order();
        order.setServerID(1);
        order.setOrderDate(LocalDateTime.now());
        order.setSubTotal(new BigDecimal("10.00"));
        order.setTax(new BigDecimal("5.00"));
        order.setTip(new BigDecimal("5.00"));
        order.setTotal(new BigDecimal("20.00"));

        List<OrderItem> items = new ArrayList<>();
        OrderItem item = new OrderItem();
        item.setItemID(1);
        item.setQuantity(2);
        item.setPrice(new BigDecimal("25.00"));
        items.add(item);
        order.setItems(items);

        List<Payment> payments = new ArrayList<>();
        Payment payment = new Payment();
        payment.setPaymentTypeID(1);
        payment.setAmount(new BigDecimal("65.00"));
        payments.add(payment);
        order.setPayments(payments);

        Order added = orderRepo.addOrder(order);
        assertNotNull(added);
        assertTrue(added.getOrderID() > 0);
        assertEquals(order.getTotal(), added.getTotal());

        // Optional to avoid extra null checks
        Optional<Order> check = Optional.of(orderRepo.getOrderById(added.getOrderID()));
        assertTrue(check.isPresent());
    }

    @Test
    public void testUpdateOrderChangesData() throws Exception {
        Order order = orderRepo.getOrderById(1);
        BigDecimal newTotal = order.getTotal().add(new BigDecimal("10.00"));
        order.setTotal(newTotal);

        orderRepo.updateOrder(order);

        Order updated = orderRepo.getOrderById(1);
        assertEquals(newTotal, updated.getTotal());
    }
    @Test
    public void testDeleteOrder_removesOrder() throws Exception {
        Order original = orderRepo.getOrderById(1);

        Order deleted = orderRepo.deleteOrder(1);
        assertEquals(original.getOrderID(), deleted.getOrderID());

        assertThrows(RecordNotFoundException.class, () -> {
            orderRepo.getOrderById(1);
        });
    }
}