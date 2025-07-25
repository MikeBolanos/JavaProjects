package com.example.jdbc.summative.data.impl;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.data.interfaces.OrderRepo;
import com.example.jdbc.summative.data.mappers.OrderItemRowMapper;
import com.example.jdbc.summative.data.mappers.OrderRowMapper;
import com.example.jdbc.summative.data.mappers.PaymentRowMapper;
import com.example.jdbc.summative.data.mappers.ServerRowMapper;
import com.example.jdbc.summative.model.Order;
import com.example.jdbc.summative.model.OrderItem;
import com.example.jdbc.summative.model.Payment;
import com.example.jdbc.summative.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MySQLOrderRepo implements OrderRepo {

    private final JdbcTemplate jdbcTemplate;
    private final OrderRowMapper orderRowMapper;
    private final ServerRowMapper serverRowMapper;
    private final OrderItemRowMapper orderItemRowMapper;
    private final PaymentRowMapper paymentRowMapper;

    public MySQLOrderRepo(JdbcTemplate jdbcTemplate,
                          OrderRowMapper orderRowMapper,
                          ServerRowMapper serverRowMapper,
                          OrderItemRowMapper orderItemRowMapper,
                          PaymentRowMapper paymentRowMapper) {

        this.jdbcTemplate = jdbcTemplate;
        this.orderRowMapper = orderRowMapper;
        this.serverRowMapper = serverRowMapper;
        this.orderItemRowMapper = orderItemRowMapper;
        this.paymentRowMapper = paymentRowMapper;
    }

    @Override
    public Order getOrderById(int id) throws RecordNotFoundException, InternalErrorException {
        // Get Order
        String sql = """
            Select * From `Order`
            WHERE orderID = ?
        """;
        List<Order> orders = jdbcTemplate.query(sql, orderRowMapper, id);

        if (orders.isEmpty()) {
            throw new RecordNotFoundException("Order with ID: " + id + " not found");
        }
        Order order = orders.get(0);

        // Get Server
        String serverSql = """ 
            Select * FROM Server
            WHERE serverID = ?
        """;
        Server server = jdbcTemplate.queryForObject(serverSql,
                serverRowMapper,
                order.getServerID());
        order.setServer(server);

        // Get OrderItems
        String itemSql = """
            SELECT * FROM OrderItem
            WHERE orderId = ?
        """;
        List<OrderItem> items = jdbcTemplate.query(itemSql,
                orderItemRowMapper,
                id);
        order.setItems(items);

        // Get Payments
        String paymentSql = """
            SELECT * FROM Payment
            WHERE orderID = ?
        """;
        List<Payment> payments = jdbcTemplate.query(paymentSql,
                paymentRowMapper,
                id);
        order.setPayments(payments);

        return order;

    }

    @Override
    public List<Order> getAllOrders() throws InternalErrorException, RecordNotFoundException {
        // Get All orders
        String sql = "SELECT * FROM `Order`";
        List<Order> orders = jdbcTemplate.query(sql, orderRowMapper);

        for (Order order : orders) {
            int orderId = order.getOrderID();

            // Fetch and set the server for each order
            String serverSql = """
                SELECT * FROM Server
                WHERE serverID = ?
            """;

            Server server = jdbcTemplate.queryForObject(serverSql, serverRowMapper, order.getServerID());
            order.setServer(server);

            // Fetch and set order items for each order
            String itemsSql = """
                SELECT * FROM OrderItem
                WHERE orderID = ?
            """;

            List<OrderItem> items = jdbcTemplate.query(itemsSql, orderItemRowMapper, orderId);
            order.setItems(items);

            // Fetch and set payments for each order
            String paymentSql = """
                SELECT * FROM Payment
                WHERE orderID = ?
            """;

            List<Payment> payments = jdbcTemplate.query(paymentSql, paymentRowMapper, orderId);
            order.setPayments(payments);
        }

        return orders;
    }

    @Override
    public Order addOrder(Order order) throws InternalErrorException {
        // Insert into Order table and get generated orderID
        String sql = """
        INSERT INTO `Order` (serverID, orderDate, subTotal, tax, tip, total)
        VALUES (?, ?, ?, ?, ?, ?)
    """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getServerID());
            ps.setObject(2, order.getOrderDate());
            ps.setBigDecimal(3, order.getSubTotal());
            ps.setBigDecimal(4, order.getTax());
            ps.setBigDecimal(5, order.getTip());
            ps.setBigDecimal(6, order.getTotal());
            return ps;
        }, keyHolder);

        int orderID = keyHolder.getKey().intValue();
        order.setOrderID(orderID);

        // Insert OrderItems for this order
        String itemSql = """
        INSERT INTO OrderItem (orderID, itemID, quantity, price)
        VALUES (?, ?, ?, ?)
    """;

        for (OrderItem item : order.getItems()) {
            jdbcTemplate.update(itemSql,
                    orderID,
                    item.getItemID(),
                    item.getQuantity(),
                    item.getPrice()
            );
        }

        // Insert Payments for this order
        String paymentSql = """
        INSERT INTO Payment (orderID, paymentTypeID, amount)
        VALUES (?, ?, ?)
    """;

        for (Payment payment : order.getPayments()) {
            jdbcTemplate.update(paymentSql,
                    orderID,
                    payment.getPaymentTypeID(),
                    payment.getAmount()
            );
        }

        return order;
    }

    @Override
    public void updateOrder(Order order) throws InternalErrorException, RecordNotFoundException {
        // Step 1: Update the Order table
        String sql = """
        UPDATE `Order`
        SET serverID = ?, orderDate = ?, subTotal = ?, tax = ?, tip = ?, total = ?
        WHERE orderID = ?
    """;

        int rowsAffected = jdbcTemplate.update(sql,
                order.getServerID(),
                order.getOrderDate(),
                order.getSubTotal(),
                order.getTax(),
                order.getTip(),
                order.getTotal(),
                order.getOrderID()
        );

        if (rowsAffected == 0) {
            throw new RecordNotFoundException("Order ID " + order.getOrderID() + " not found");
        }

        // Step 2: Delete old OrderItems and re-insert the new ones
        jdbcTemplate.update("DELETE FROM OrderItem WHERE orderID = ?", order.getOrderID());

        String itemSql = """
        INSERT INTO OrderItem (orderID, itemID, quantity, price)
        VALUES (?, ?, ?, ?)
    """;

        for (OrderItem item : order.getItems()) {
            jdbcTemplate.update(itemSql,
                    order.getOrderID(),
                    item.getItemID(),
                    item.getQuantity(),
                    item.getPrice()
            );
        }

        // Delete old Payments and re-insert the new ones
        jdbcTemplate.update("DELETE FROM Payment WHERE orderID = ?", order.getOrderID());

        String paymentSql = """
        INSERT INTO Payment (orderID, paymentTypeID, amount)
        VALUES (?, ?, ?)
    """;

        for (Payment payment : order.getPayments()) {
            jdbcTemplate.update(paymentSql,
                    order.getOrderID(),
                    payment.getPaymentTypeID(),
                    payment.getAmount()
            );
        }
    }


    @Override
    public Order deleteOrder(int id) throws InternalErrorException, RecordNotFoundException {
        // Get order
        Order order = getOrderById(id);

        // Delete OrderItems
        String deleteItemsSql = """
            DELETE FROM OrderItem
            WHERE orderID = ?
        """;
        jdbcTemplate.update(deleteItemsSql, id);

        // Delete Payments
        String deletePaymentsSql = """
            DELETE FROM Payment
            WHERE orderID = ?
        """;
        jdbcTemplate.update(deletePaymentsSql, id);

        // Delete the Order
        String deleteOrderSql = """
            DELETE FROM `Order`
            WHERE orderID = ?
        """;
        jdbcTemplate.update(deleteOrderSql, id);

        return order;
    }
}
