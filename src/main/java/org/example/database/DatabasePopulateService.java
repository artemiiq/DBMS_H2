package org.example.database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = Files.readString(Paths.get("src/main/resources/sql/populate_db.sql"));
            stmt.execute(sql);

            System.out.println("Database populated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}