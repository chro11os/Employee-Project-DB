package org.nbg.database;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConnectionTest {

    @Test
    public void testNeilUserExists() {
        // Query the database to verify that the user/role "neil" exists
        boolean exists = connection.checkUserExists("neil");
        
        System.out.println("Database check result: User 'neil' exists? " + exists);
        
        // Assert that the user is present
        assertTrue(exists, "Verification failed: The database role 'neil' was not found!");
    }
}
