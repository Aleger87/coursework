
import java.util.Arrays;
import java.util.Random;



public class EmployeeBook {
   // private Employee[] arr;

    //public EmployeeBook (Employee[] arr){
      //  this.arr = arr;
    //}

    public void getStartTaskOne(Employee[] arr) {
        float totalSalary = sumSalary(arr);
        float maxSalary = maxSalary(arr);
        float minSalary = minSalary(arr);
        String employeeMaxSalary = employeeAnySalary(arr, maxSalary);
        String employeeMinSalary = employeeAnySalary(arr, minSalary);
        float avgSalary = totalSalary/arr.length;
        System.out.println ("\nСумма затрат в месяц: " + totalSalary +
                            "\nСотрудник с максимальной зарплатой - "+employeeMaxSalary+   " - " + maxSalary +
                            "\nСотрудник с минимальной зарплатой - "+ employeeMinSalary + " - " +minSalary +
                            "\nСредняя зарплата - " + avgSalary);

    }

    public void getStartTaskTwo(Employee[] arr) {
        float index  = -0.10f;                                                                               // процент индексации
        System.out.println("\nИндексация на " + (int) Math.round(index * 100) + "%\n");
        indexSalary(arr, index);                                                                            //вывод массива после индексации
        System.out.println("\nРабота с отделом\n");
        int departmentIndex = randomNumber(arr.length, 0);                                               //выбираем случайный индекс массива
        int department = arr[departmentIndex].getDepartment();                                             //выбираем отдел по индексу
        int counter = counterEmployee(arr, department, 0);                                   //счетчик сотрудников отдела
        float totalSalaryDepartment = totalSalaryDepartment(arr, department);                             //сумма по отделу
        float maxSalaryDepartment = maxSalaryDepartment(arr, department);                                 //максимум по отделу
        float minSalaryDepartment = arr[minSalaryInDepartment(arr, department)].getSalary();              // минимум по отделу

        String employeeMaxSalaryInDepartment = employeeAnySalary(arr, maxSalaryDepartment);
        String employeeMinSalaryInDepartment = employeeAnySalary(arr, minSalaryDepartment);
        float avgSalaryDepartment = totalSalaryDepartment / counter;


        System.out.println("Сумма затрат на зарплату по отделу №" + department + " - " + totalSalaryDepartment +
                " \nСотрудник с максимальной зарплатой по отделу №" +department + " - "+ employeeMaxSalaryInDepartment +" - " + maxSalaryDepartment +
                " \nСотрудник с минимальной зарплатой по отделу №" + department + " - " + employeeMinSalaryInDepartment + " " + minSalaryDepartment +
                " \nСредняя сумма затрат на зарплату по отделу №" + department + " - " + avgSalaryDepartment);

        System.out.println("Печать всех данных всех сотрудников отдела №" +department+", кроме номера отдела.");
        printEmployeesDepartment (arr, department);
    }

    private float maxSalaryDepartment(Employee[] arr, int department) {
        float maxSalaryDepartment = 0f;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department && maxSalaryDepartment < arr[i].getSalary()) {
                    maxSalaryDepartment = arr[i].getSalary();
            }
        }
        return maxSalaryDepartment;
    }

    private float totalSalaryDepartment(Employee[] arr, int department) {
        float  totalSalaryDepartment = 0f;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department) {
                totalSalaryDepartment = totalSalaryDepartment + arr[i].getSalary();
            }

        }

        return totalSalaryDepartment;
    }

    private int counterEmployee(Employee[] arr, int department, int counterEmployee) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department) {
                counterEmployee++;
            }
        }
        return counterEmployee;
    }

    private Employee[] indexSalary (Employee[] arr, float ind) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].setSalary(arr[i].getSalary() + arr[i].getSalary() * ind);
            System.out.println(arr[i]);
        }
        return arr;
    }

    public Employee[] addEmployeesToArray(Employee[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int department = randomNumber(5,1);
            float salary= rnd.nextInt(100_000) + 50_000f;
            Employee employee = new Employee("Петров Петр Петрович"+i, department, salary);
            arr[i] = employee;
            System.out.println(employee);
        }
        return arr;
    }


    private int randomNumber(int i, int j) {
        Random rnd = new Random();
        return  rnd.nextInt(i)+j;

    }
    private void printEmployeesDepartment(Employee[] employees, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println( employees[i].getId() + " " +employees[i].getEmployee() + " " +employees[i].getSalary());
            }

        }

    }

    private  String employeeAnySalary(Employee[] arr, float salary) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() == salary) {
                return arr[i].getEmployee();
            }
        }
        return "";
    }

    private float maxSalary(Employee[] arr) {
        float element = 0.0f;
        for (int i = 0; i < arr.length; i++) {
            if (element < arr[i].getSalary()) {
                element = arr[i].getSalary();
            }
        }
        return element;
    }

    private float minSalary(Employee[] arr) {
        float element = arr[0].getSalary();
        for (int i = 0; i < arr.length; i++) {
            if (element > arr[i].getSalary()) {
                element = arr[i].getSalary();
            }
        }
        return element;
    }

    private int  minSalaryInDepartment(Employee[] arr, int department) {
        int element = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department) {
                element = arr[i].id-1;
            }
        }
        return element;
    }


    private float sumSalary(Employee[] arr) {
        float slr = 0;
        for (int i = 0; i < arr.length; i++) {
            slr = slr + arr[i].getSalary();
        }
        return slr;
    }

    public void replaceEmployee(Employee[] arr, String employee, int department, float salary, int id){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getId() == id) {
                arr[i].setEmployee(employee);
                arr[i].setDepartment(department);
                arr[i].setSalary(salary);

            }
        }
    }

    public void deleteEmployee(Employee[] arr, int id){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getId() == id) {
                arr[i] = null;
            }
        }
    }

    public void addEmployee(Employee[] arr, String employee, int department, float salary){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                Employee emp = new Employee(employee, department, salary);
                arr[i] = emp;
            }
        }
    }
}
