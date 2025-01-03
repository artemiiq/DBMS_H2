package org.example.database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> results = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = Files.readString(Paths.get("src/main/resources/sql/find_max_projects_client.sql"));
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                results.add(new MaxProjectCountClient(rs.getString("name"), rs.getInt("project_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}

class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{name='" + name + "', projectCount=" + projectCount + '}';
    }
}