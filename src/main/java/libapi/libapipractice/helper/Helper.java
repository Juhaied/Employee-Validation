package libapi.libapipractice.helper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import libapi.libapipractice.entity.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
public class Helper {
    public static List<Employee> csvToDataBase(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Employee> tutorials = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();


            ////employeeId, date, name, startTime, endDate, shiftName, ExpectedValue
            for (CSVRecord csvRecord : csvRecords) {
                Employee tutorial = new Employee(
                        Integer.parseInt(csvRecord.get("Employee ID")),
                        csvRecord.get("Date"),
                        csvRecord.get("Name"),
                        csvRecord.get("Start time"),
                        csvRecord.get("End Date"),
                        csvRecord.get("Shift Name"),
                        csvRecord.get("Expected value")
                );
                tutorials.add(tutorial);
            }
         //   debug(tutorials);
            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }


    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }

}