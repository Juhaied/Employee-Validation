package libapi.libapipractice.validation;

import libapi.libapipractice.entity.Employee;
import libapi.libapipractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.*;

public class FileValidation {

    public static String isValid(EmployeeService employeeService) {
        List<Employee> employees = employeeService.findAll();
        if (!isDayValid(employees)) return "dayError";
        for (Employee employee: employees)  {
            //checking one Person work hours
            String start = employee.getStartTime();
            //h, min, sec, type
            String[] timeStart = start.split(":");
            String end = employee.getEndDate();
            String[] timeEnd = end.split(":");

            long h = 0;
            {
                //hour
                long sH = Long.parseLong(timeStart[0]);
                long eH = Long.parseLong(timeEnd[0]);
                String phase = timeStart[2].charAt(3) +""+ timeStart[2].charAt(4);
                String phase2 = timeEnd[2].charAt(3) + "" + timeStart[2].charAt(4);
                String currPhase = phase;
                for (int i = 0; ; i++) {
                    if (sH == eH && currPhase.equals(phase2)) {
                        break;
                    }
                    h++;
                    if (sH == 12) {
                        sH = 1;
                        if (currPhase.equals("AM")) currPhase = "PM";
                        else currPhase = "AM";
                    }
                    if (sH == eH && currPhase.equals(phase2)) {
                        break;
                    }
                    sH++;
                }
            }
            //minute
            long totMin = 60 - Long.parseLong(timeStart[1]) + Long.parseLong(timeEnd[1]);
            //second
            String start_sec[] = timeStart[2].split(" ");
            String end_sec[] = timeEnd[2].split(" ");
            long second = 60 - Long.parseLong(start_sec[0])+Long.parseLong(end_sec[0]);
            if(second == 60) second = 0;
            //total in second
            long seconds = h * 60 * 60 + totMin * 60 + second;
            long nitHours = seconds / (60 * 60);
            if (nitHours >= 16) return "hourError";
        }

        return "ok";
    }

    static boolean isDayValid(List<Employee> employees) {
        int cnt = 0;
        int id = -1;
        for (Employee emp: employees) {
            int currId = emp.getEmployeeId();
            if (id == currId) cnt++;
            else {
                debug(cnt);
                if (cnt >= 6) return false;
                cnt = 1;
                id = currId;
            }
        }
        if (cnt >= 6) return false;
      //  debug(cnt);
        return true;
    }
    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}
