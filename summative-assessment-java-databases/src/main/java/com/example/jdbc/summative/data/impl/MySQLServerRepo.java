package com.example.jdbc.summative.data.impl;


import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.data.interfaces.ServerRepo;
import com.example.jdbc.summative.model.Server;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public class MySQLServerRepo implements ServerRepo {
    @Override
    public Server getServerById(int id) throws InternalErrorException, RecordNotFoundException {
        return null;
    }

    @Override
    public List<Server> getAllAvailableServers(LocalDate date) throws InternalErrorException {
        return List.of();
    }
}
