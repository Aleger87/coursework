import java.util.Objects;

public class Employee {
    static int counter =1;

    String employee;
    int department;
    float salary;
    int id;

    public Employee(String employee, int department, float salary) {
        this.employee = employee;
        this.department = department;
        this.salary = salary;
        id = counter;
        counter++;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
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

    public float getSalary() {
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
        Employee that = (Employee) o;
        return department == that.department && salary == that.salary && id == that.id && employee.equalsIgnoreCase(that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, department, salary, id);
    }

}
