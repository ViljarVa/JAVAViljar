package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/employee/createEmployee?firstName=Test&lastName=Kasutaja
    @GetMapping("employee/createEmployee")
    public String createEmployee(String firstName, String lastName) {

        String sql = "insert into employee (first_name, last_name) VALUES(:m1, :m2)";
        Map paramMap = new HashMap();
        paramMap.put("m1", firstName);
        paramMap.put("m2", lastName);
        jdbcTemplate.update(sql, paramMap);
        return "Kasutaja on loodud";
    }

    // http:/localhost:8080/employee/deleteEmployee?id=3
    @GetMapping("employee/deleteEmployee")
    public String deleteEmployee(int id) {
        String sql = "delete from employee where id=:i";
        Map paramMap = new HashMap();
        paramMap.put("i", id);
        jdbcTemplate.update(sql, paramMap);
        return "Kasutaja on kustutatud";

    }

    //Teenus, muuda töötaja andmeid. Sisend id: (millist muudame), firstName, lastName
    @GetMapping("employee/updateEmployee")
    public String editEmployee(String firstName, String lastName, Integer id) {
        String sql = "UPDATE employee SET first_name = :a, last_name :b WHERE id = :id";
        Map paramMap = new HashMap();
        paramMap.put("i", id);
        paramMap.put("b", lastName);
        paramMap.put("a", firstName);
        jdbcTemplate.update(sql, paramMap);
        return "Kasutaja on muudetud";
    }


    //http://localhost:8080/employee/getFirstName?id=1
    @GetMapping("employee/getFirstName")
    public String getEmployeeName(Integer id) {
        String sql = "SELECT first_name FROM employee WHERE id = :id";
        Map paramMap = new HashMap();
        paramMap.put("id", id);
        String firstName = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return firstName;
    }

    //http://localhost:8080/employee/allEmployees
    @GetMapping("employee/allEmployees")
    public List<EmployeeDto> allEmployees(int id){
        String sql = "SELECT * from employee";
        Map paramMap = new HashMap();
        paramMap.put("i", id);
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(EmployeeDto.class));
    }

}

