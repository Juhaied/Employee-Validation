package libapi.libapipractice.rest;

import libapi.libapipractice.helper.Helper;
import libapi.libapipractice.service.EmployeeService;
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

    @PostMapping("/home")
    public String home(@RequestParam(name = "file")MultipartFile file) {
        try {
            employeeService.saveAll(Helper.csvToTutorials(file.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}
