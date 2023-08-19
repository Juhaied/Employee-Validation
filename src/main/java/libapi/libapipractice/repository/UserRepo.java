package libapi.libapipractice.repository;

import libapi.libapipractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;


@Repository
//entity user
//primary key Integer
/*
JpaRepository<User, Integer>:
The JpaRepository interface is part of Spring Data JPA
and provides a set of built-in methods for common CRUD operations on JPA entities.
 */
public interface UserRepo extends JpaRepository<User, Integer> {
}
