package ee.bcs.java.solution.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeControllerSample {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/sample/employee/createEmployee?firstName=Test&lastName=Kasutaja
    @GetMapping("sample/employee/createEmployee")
    public String createEmployee(String firstName, String lastName) {
        String sql = "INSERT INTO employee (first_name, last_name) VALUES (:m1, :m2)";
        Map paramMap = new HashMap();
        paramMap.put("m1", firstName);
        paramMap.put("m2", lastName);
        jdbcTemplate.update(sql, paramMap);
        return "Kasutaja on loodud";
    }

    //TODO, teha teenus kustuta töötaja. Sisend: id

    // TODO, teha teenus muuda töötaja andmeid
    //  Sisend:
    //  id(millist me muudame), firstName, lastName

    // TODO, tagasta id järgi töötaja nimi
    // http://localhost:8080/sample/employee/getFirstName?id=1
    @GetMapping("sample/employee/getFirstName")
    public String getEmployeeName(Integer id){
        String sql = "SELECT first_name FROM employee WHERE id = :id";
        Map paramMap = new HashMap();
        paramMap.put("id", id);
        String firstName = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return firstName;
    }

    // lihtne versioon
    // http://localhost:8080/sample/employee/get1?id=1
    @GetMapping("sample/employee/get1")
    public EmployeeSample getEmployee1(Integer id){
        String sql = "SELECT * FROM employee WHERE id = :id";
        Map paramMap = new HashMap();
        paramMap.put("id", id);
        EmployeeSample employee = jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(EmployeeSample.class));
        return employee;
    }

    // http://localhost:8080/employee/all
    @GetMapping("sample/employee/all")
    public List<EmployeeSample> getAllEmployees(){
        String sql = "SELECT * FROM employee";
        Map paramMap = new HashMap();
        List<EmployeeSample> employees = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(EmployeeSample.class));
        return employees;
    }

    // raskem versioon
    //http://localhost:8080/employee/get2?id=1
    @GetMapping("sample/employee/get2")
    public EmployeeSample getEmployee2(Integer id){
        String sql = "SELECT * FROM employee WHERE id = :id";
        Map paramMap = new HashMap();
        paramMap.put("id", id);
        EmployeeSample employee = jdbcTemplate.queryForObject(sql, paramMap, new EmployeeRowMapper());
        return employee;
    }

    private class EmployeeRowMapper implements RowMapper<EmployeeSample> {
        @Override
        public EmployeeSample mapRow(ResultSet resultSet, int i) throws SQLException {
            EmployeeSample employee = new EmployeeSample();
            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            return employee;
        }
    }

}
