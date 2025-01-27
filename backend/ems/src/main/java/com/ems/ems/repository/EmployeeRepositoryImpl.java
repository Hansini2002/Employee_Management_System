package com.ems.ems.repository;

import com.ems.ems.model.Employee;
import com.ems.ems.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    // RowMapper to map ResultSet to Employee object
    private final RowMapper<Employee> rowMapper = (rs, rowNum) -> {
        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setFirstName(rs.getString("firstname"));
        employee.setLastName(rs.getString("lastname"));
        employee.setEmail(rs.getString("email"));
        employee.setDob(rs.getDate("dob").toLocalDate());
        employee.setGender(Gender.valueOf(rs.getString("gender")));
        employee.setTelephoneNo(rs.getString("telephone_no"));
        employee.setAddress(rs.getString("address"));
        employee.setCity(rs.getString("city"));
        return employee;
    };

    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, id);
        return employees.isEmpty() ? Optional.empty() : Optional.of(employees.get(0));
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee (firstname, lastname, email, dob, gender, telephone_no, address, city) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getDob(), employee.getGender(), employee.getTelephoneNo(),
                employee.getAddress(), employee.getCity());
    }

    @Override
    public void update(Long id, Employee employee) {
        String sql = "UPDATE employee SET firstname = ?, lastname = ?, email = ?, dob = ?, gender = ?, " +
                "telephone_no = ?, address = ?, city = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getDob(), employee.getGender(), employee.getTelephoneNo(),
                employee.getAddress(), employee.getCity(), id);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
