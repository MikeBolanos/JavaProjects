package com.example.jdbc.summative.data.interfaces;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.model.Order;

import java.util.List;

public interface OrderRepo {
    public Order getOrderById(int id) throws RecordNotFoundException, InternalErrorException;
    public List<Order> getAllOrders() throws InternalErrorException, RecordNotFoundException;
    public Order addOrder(Order order) throws InternalErrorException;
    public void updateOrder(Order order) throws InternalErrorException;
    public Order deleteOrder(int id) throws InternalErrorException;
}
