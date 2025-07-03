package dao;

import model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DatabaseConnection;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee viewEmployee(int id) {
        String query = "SELECT * FROM employees WHERE id = ?";
        Employee employee = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void updateEmployee(Employee employee) {
        String query = "UPDATE employees SET name = ?, position = ?, salary = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setInt(4, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}