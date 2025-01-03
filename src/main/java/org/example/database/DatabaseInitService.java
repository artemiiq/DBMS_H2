package org.example.database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = Files.readString(Paths.get("src/main/resources/sql/init_db.sql"));
            stmt.execute(sql);

            System.out.println("Database initialized successfully.");
    } catch (Exception e) {
        e.printStackTrace();}
    }
}
