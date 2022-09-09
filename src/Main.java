public class Main {
    public static void main(String[] args) {
       Employee[] employees = new Employee[10];
       EmployeeBook.addEmployeesToArray(employees);
       EmployeeBook.getStartTaskOne(employees);
       EmployeeBook.getStartTaskTwo(employees);
       System.out.println("\nДобавление изменение сотрудников\n");
       int id = 6;
       EmployeeBook.deleteEmployee(employees,id); //удаление сотрудника по id

       System.out.println(employees[id-1] + " Сотрудник с id - " + id + " уволен\n");

       Employee newEmployee = new Employee("Степанов Степан Степанович" , 1, 100);
       EmployeeBook.addEmployee(employees, newEmployee);  // добавление нового сотрудника в пустую ячейку
        Employee replaceEmployee = new Employee("Иванов Иван Иванович" , 1, 200);
        EmployeeBook.replaceEmployee(employees, replaceEmployee, 7); // изменение данных сотрудника по id,

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }


    }

}