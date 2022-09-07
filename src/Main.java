import java.util.Random;

public class Main {
    public static void main(String[] args) {
       Employee[] employees = new Employee[10];
       EmployeeBook employeeBook  = new EmployeeBook();
       employeeBook.addEmployeesToArray(employees);
       employeeBook.getStartTaskOne(employees);
        employeeBook.getStartTaskTwo(employees);
       System.out.println("\nДобавление изменение сотрудников\n");
       int id = 6;
       employeeBook.deleteEmployee(employees,id); //удаление сотрудника по id

       System.out.println(employees[id-1] + " Сотрудник с id - " + id + " уволен\n");

       employeeBook.addEmployee(employees, "Сидоров Петр Михайлович",1, 100);  // добавление нового сотрудника в пустую ячейку
       employeeBook.replaceEmployee(employees,"Иванов Иван Иванович", 4, 1_000_000, 2); // изменение данных сотрудника по id
       for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

    }

}