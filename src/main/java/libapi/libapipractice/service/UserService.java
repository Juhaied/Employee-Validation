package libapi.libapipractice.service;

import libapi.libapipractice.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> findAllUser();
}
