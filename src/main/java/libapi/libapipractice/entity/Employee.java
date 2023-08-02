package libapi.libapipractice.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "date")
    private String data;
    @Column(name = "name")
    private String name;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "shift_name")
    private String shiftName;
    @Column(name = "expected_value")
    private String expectedValue;

    public Employee(int id, String data, String name, String startTime, String endDate, String shiftName, String expectedValue) {
        this.employeeId = id;
        this.data = data;
        this.name = name;
        this.startTime = startTime;
        this.endDate = endDate;
        this.shiftName = shiftName;
        this.expectedValue = expectedValue;
    }

    public Employee() {
        super();
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", data='" + data + '\'' +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endDate='" + endDate + '\'' +
                ", shiftName='" + shiftName + '\'' +
                ", expectedValue='" + expectedValue + '\'' +
                '}';
    }
}
