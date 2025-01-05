package org.example.database;

import java.nio.file.*;
import java.sql.*;
import java.util.*;

public class DatabaseQueryService {

    // Метод для запиту "find_max_salary_worker.sql"
    public List<Worker> findMaxSalaryWorker() {
        List<Worker> result = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection()) {
            String sql = Files.readString(Paths.get("sql/find_max_salary_worker.sql"));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result.add(new Worker(rs.getString("name"), rs.getInt("salary")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Метод для запиту "find_max_projects_client.sql"
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection()) {
            String sql = Files.readString(Paths.get("sql/find_max_projects_client.sql"));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result.add(new MaxProjectCountClient(rs.getString("name"), rs.getInt("project_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Метод для запиту "find_longest_project.sql"
    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection()) {
            String sql = Files.readString(Paths.get("sql/find_longest_project.sql"));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result.add(new LongestProject(rs.getString("name"), rs.getInt("month_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Метод для запиту "find_youngest_eldest_workers.sql"
    public List<WorkerAge> findYoungestAndEldestWorkers() {
        List<WorkerAge> result = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection()) {
            String sql = Files.readString(Paths.get("sql/find_youngest_eldest_workers.sql"));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result.add(new WorkerAge(rs.getString("type"), rs.getString("name"), rs.getDate("birthday").toLocalDate()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Метод для запиту "print_project_prices.sql"
    public List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> result = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection()) {
            String sql = Files.readString(Paths.get("sql/print_project_prices.sql"));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result.add(new ProjectPrice(rs.getString("name"), rs.getBigDecimal("price")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}