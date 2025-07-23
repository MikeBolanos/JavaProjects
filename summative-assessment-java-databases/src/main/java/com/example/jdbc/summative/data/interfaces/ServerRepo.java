package com.example.jdbc.summative.data.interfaces;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.model.Server;

import java.time.LocalDate;
import java.util.List;

public interface ServerRepo {
    Server getServerById(int id) throws InternalErrorException, RecordNotFoundException;

    //Servers have a HireDate and a TermDate.
    //Return only servers where the given date falls in between the HireDate and TermDate inclusive.
    List<Server> getAllAvailableServers(LocalDate date) throws InternalErrorException;
}
