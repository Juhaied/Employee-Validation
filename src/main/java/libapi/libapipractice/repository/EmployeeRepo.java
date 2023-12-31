package libapi.libapipractice.repository;

import libapi.libapipractice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
