import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание лайт 1");
        taskLiteOne();

        System.out.println("Задание Лайт 2");
        taskLiteTwo();

    }

    private static void taskLiteOne() {
        EmployeeBook[] employees = new EmployeeBook[10];
        addEmployeesToArray(employees);
        int sumSalary = 0;
        int maxSalary = 0;
        String employeeMaxSalary = "";
        int minSalary = employees[0].getSalary();
        String employeeMinSalary = employees[0].getEmployee();


        System.out.println("Список сотрудников:");

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            sumSalary = sumSalary +  employees[i].getSalary();
        }

        System.out.println("Сумма затрат в месяц: "+sumSalary);

        for (int i = 0; i < employees.length; i++) {
            if(maxSalary < employees[i].getSalary()){
                maxSalary = employees[i].getSalary();
                employeeMaxSalary = employees[i].getEmployee();
            } else if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                employeeMinSalary = employees[i].getEmployee();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - "+ employeeMaxSalary + " - " +maxSalary +
                "\nСотрудник с минимальной зарплатой - "+ employeeMinSalary + " - " +minSalary);

        int avgSalary = sumSalary / employees.length;
        System.out.println("Средняя зарплата - " + avgSalary);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getEmployee());
        }
    }

    private static void taskLiteTwo() {


    }

    public static void addEmployeesToArray(Object[] arr) {
        int salary=100_000;
        for (int i = 0; i < arr.length; i++) {
            EmployeeBook employee = new EmployeeBook("Иванов Иван Иванович"+i, 1+i, salary);
            arr[i] = employee;
            salary += salary;
            //System.out.println(employee);
        }
    }


}