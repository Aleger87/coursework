import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    static int counter =1;

    String employee;
    int department;
    int salary;
    int id;

    public EmployeeBook(String employee, int department, int salary) {
        this.employee = employee;
        this.department = department;
        this.salary = salary;
        id = counter;
        counter++;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getCounter() {
        return counter;
    }

    public String getEmployee() {
        return employee;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " +employee + " " + department +" "+ salary;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return department == that.department && salary == that.salary && id == that.id && employee.equalsIgnoreCase(that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, department, salary, id);
    }
//private String[] employees = {};

}
