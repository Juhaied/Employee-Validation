package libapi.libapipractice.rest;

import libapi.libapipractice.entity.User;
import libapi.libapipractice.helper.Helper;
import libapi.libapipractice.service.EmployeeService;
import libapi.libapipractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;


@RestController
@RequestMapping("/api")
public class HomeRestController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    @PostMapping("/home")
    public String home(@RequestParam(name = "file")MultipartFile file) {
        try {
            employeeService.saveAll(Helper.csvToDataBase(file.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }


    @GetMapping("/users")
    public List<User> getUSer() {
        return userService.findAllUser();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}
