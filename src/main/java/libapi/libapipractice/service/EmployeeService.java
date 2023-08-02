package libapi.libapipractice.service;

import libapi.libapipractice.entity.Employee;

import java.io.*;
import java.util.*;

public interface EmployeeService {
    void save(Employee employee);
    Employee findById(int id);
    List<Employee> findAll();
    void delete(int id);
    void deleteAll();
    void saveAll(List<Employee> employees);
}
