package com.example.jdbc.summative;

import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.impl.MySQLServerRepo;
import com.example.jdbc.summative.model.Server;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Sql(scripts = "/sql/reset_db.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class MySQLServerRepoTest {
    @Autowired
    private MySQLServerRepo repo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testGetServerByIdWithValidId() {
        jdbcTemplate.update("""
            INSERT INTO Server (ServerID, FirstName, LastName, HireDate, TermDate)
            VALUES (405, 'Alice', 'Walker', '2021-03-01', NULL)
        """);

        try {
            Server server = repo.getServerById(405);

            assertNotNull(server);
            assertEquals(405, server.getServerID());
            assertEquals("Alice", server.getFirstName());
            assertEquals("Walker", server.getLastName());
            assertEquals(LocalDate.of(2021, 3, 1), server.getHireDate());
            assertNull(server.getTermDate());
        } catch (Exception ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void testGetAllAvailableServersWithValidDate() {
        LocalDate date = LocalDate.of(2021, 01, 01);

        try {
            List<Server> servers = repo.getAllAvailableServers(date);

            assertEquals(12, servers.size());
            assertTrue(servers.stream().anyMatch(s -> s.getServerID() == 1));
            assertTrue(servers.stream().anyMatch(s -> s.getServerID() == 3));
            assertTrue(servers.stream().anyMatch(s -> s.getServerID() == 10));
            assertTrue(servers.stream().anyMatch(s -> s.getServerID() == 14));
            assertTrue(servers.stream().anyMatch(s -> s.getServerID() == 17));
            assertTrue(servers.stream().anyMatch(s -> s.getServerID() == 20));
            assertTrue(servers.stream().anyMatch(s -> s.getServerID() == 201));

        } catch (InternalErrorException ex) {
            fail("Unexpected error: " + ex.getMessage());
        }
    }
}