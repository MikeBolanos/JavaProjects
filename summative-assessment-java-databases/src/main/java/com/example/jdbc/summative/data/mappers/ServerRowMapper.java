package com.example.jdbc.summative.data.mappers;

import com.example.jdbc.summative.model.Server;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class ServerRowMapper implements RowMapper<Server> {

    @Override
    public Server mapRow(ResultSet rs, int rowNum) throws SQLException {
        Server server = new Server();

        server.setServerID(rs.getInt("ServerID"));
        server.setFirstName(rs.getString("FirstName"));
        server.setLastName(rs.getString("LastName"));
        server.setHireDate(rs.getObject("HireDate", LocalDate.class));
        // TermDate may be null, so this checks for that.
        LocalDate termDate = rs.getObject("TermDate", LocalDate.class);
        server.setTermDate(termDate);

        return server;
    }
}
