package com.example.jdbc.summative.data.impl;


import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.data.interfaces.ServerRepo;
import com.example.jdbc.summative.data.mappers.ServerRowMapper;
import com.example.jdbc.summative.model.Server;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public class MySQLServerRepo implements ServerRepo {

    private final JdbcTemplate jdbcTemplate;
    private final ServerRowMapper serverRowMapper = new ServerRowMapper();

    public MySQLServerRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Server getServerById(int id) throws InternalErrorException, RecordNotFoundException {
        String sql = """
                SELECT * FROM Server
                WHERE ServerID = ?
        """;

        try {
            List<Server> servers = jdbcTemplate.query(sql, serverRowMapper, id);

            if (servers.isEmpty()) {
                throw new RecordNotFoundException("Server with ID " + id + " not found.");
            }

            return servers.get(0);

        } catch (DataAccessException ex) {
            throw new InternalErrorException("Failed to retrieve server by ID.", ex);
        }
    }

    @Override
    public List<Server> getAllAvailableServers(LocalDate date) throws InternalErrorException {
        String sql = """
            SELECT * FROM Server
            WHERE HireDate <= ?
            AND (TermDate IS NULL OR TermDate >= ?)
            ORDER BY ServerID
        """;

        try {
            return jdbcTemplate.query(sql, serverRowMapper, date, date);
        } catch (DataAccessException ex) {
            throw new InternalErrorException("Failed to retrieve available servers.", ex);
        }
    }
}