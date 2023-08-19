package libapi.libapipractice.controller;

import libapi.libapipractice.entity.User;
import libapi.libapipractice.helper.Helper;
import libapi.libapipractice.repository.UserRepo;
import libapi.libapipractice.service.EmployeeService;
import libapi.libapipractice.service.UserService;
import libapi.libapipractice.validation.FileValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;


@Controller
public class AuthController {

    {
        System.out.println("Controller");
    }
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    /*This end point will render the home or login pag
    *This end point map to index.html page
    * */
    @GetMapping("/index")
    public String home() {
        try {
            employeeService.deleteAll();
            debug("deleted");
        } catch (Exception e) {
            e.printStackTrace();
            return "index";
        }
        return "index";
    }

    /*
    * When /upload endpoint hit it
    * will get user data
    * and will verified
    *
    * if verified, next page will be upload page
    * otherwise it will re-direct
    * */

    @PostMapping("/upload")
    public String verify(@RequestParam("email") String email, @RequestParam("password") String pass) {
        System.out.println(email + " " + pass);
        List<User> users = new ArrayList<>();
        users = userService.findAllUser();
        boolean ok = false;
        debug(users);
        for (User user: users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(pass)) {
                return "upload";
            }
        }
        return "index";
    }

    /*
    * will render the signup form
    * */
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }


    /*
    * Registration data will come here
    * data will save to the database
    * */
    @PostMapping("/userdata")
    public String form(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String pass) {
        userService.saveUser(new User(0, name, pass, email));
        return "index";
    }

    /*
    * read csv file
    * from upload html
    * */
    @PostMapping("/uploadCsv")
    public String loadCsv(@RequestParam(name = "csvfile") MultipartFile file) {
        try {
            employeeService.saveAll(Helper.csvToDataBase(file.getInputStream()));
        } catch (Exception e) {
            return "index";
        }
        return "success";
    }

    /*
    * This Method will validate the file
    * will call isValid from FileValidation
    * if isValid return ok then file is valid
    * if isValid return dayError file is error for 6days
    * Otherwise it hours error
    * */
    @GetMapping("/validation")
    public String isValid() {
        String state = FileValidation.isValid(employeeService);
        if (state.equals("ok")) return "fileisvalid";
        if (state.equals("dayError")) return "dayerror";
        return "hourerror";
    }

    public void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}
