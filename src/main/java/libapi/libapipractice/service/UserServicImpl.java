package libapi.libapipractice.service;

import libapi.libapipractice.entity.User;
import libapi.libapipractice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class UserServicImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }
}
