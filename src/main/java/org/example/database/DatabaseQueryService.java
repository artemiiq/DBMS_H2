package org.example.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private String readSqlFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading SQL file: " + filePath, e);
        }
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sql = readSqlFile("src/main/resources/sql/find_max_projects_client.sql");
        List<MaxProjectCountClient> results = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                results.add(new MaxProjectCountClient(rs.getString("name"), rs.getInt("project_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    // Додати методи для інших SQL-запитів
    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String sql = readSqlFile("src/main/resources/sql/find_max_salary_worker.sql");
        List<MaxSalaryWorker> results = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                results.add(new MaxSalaryWorker(rs.getString("name"), rs.getInt("salary")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    // Інші методи для find_longest_project, find_youngest_eldest_workers, print_project_prices
}
