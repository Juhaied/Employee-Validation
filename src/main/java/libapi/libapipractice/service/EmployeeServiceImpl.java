package libapi.libapipractice.service;

import libapi.libapipractice.entity.Employee;
import libapi.libapipractice.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optional = employeeRepo.findById(id);
        return optional.get();
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public void delete(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        employeeRepo.deleteAll();
    }
    @Override
    public void saveAll(List<Employee> employees) {
        employeeRepo.saveAll(employees);
    }
}
