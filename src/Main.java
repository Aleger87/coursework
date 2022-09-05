import java.util.Random;

public class Main {
    public static void main(String[] args) {
        EmployeeBook[] employees = new EmployeeBook[10];
        addEmployeesToArray(employees);

        System.out.println("Задание lite 1");
        taskLiteOne(employees);

        System.out.println("Задание lite 2");
        taskLiteTwo(employees);

        System.out.println("Задание medium 1");
       taskLiteThree(employees);

    }

    private static void taskLiteThree(EmployeeBook[] employees) {
        System.out.println("Индексация на 10%");
        float index = 0.1f;
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() * index);
            System.out.println(employees[i]);
        }


            int department = employees[1].getDepartment();
            float totalSalaryDepartment = 0f; //сумма по отделу
            float maxSalaryDepartment = 0f; //максимум по отделу
            float minSalaryDepartment = employees[minSalaryInDepartment(employees, department)].getSalary(); // минимум по отделу
            int counter = 0; //счетчик сотрудников
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department) {
                    totalSalaryDepartment = totalSalaryDepartment + employees[i].getSalary();//верно
                    if (maxSalaryDepartment < employees[i].getSalary()) {
                        maxSalaryDepartment = employees[i].getSalary();
                    } else if (minSalaryDepartment > employees[i].getSalary()) {
                        minSalaryDepartment = employees[i].getSalary();
                    }
                    counter++;
                }

            }


        String employeeMaxSalaryInDepartment = employeeAnySalary(employees, maxSalaryDepartment);
        String employeeMinSalaryInDepartment = employeeAnySalary(employees, minSalaryDepartment);
        float avgSalaryDepartment = totalSalaryDepartment / counter;


        System.out.println("Сумма затрат на зарплату по отделу №" + department + " - " + totalSalaryDepartment +
                             " \nСотрудник с максимальной зарплатой по отделу №" +department + " - "+ employeeMaxSalaryInDepartment +" - " + maxSalaryDepartment +
                             " \nСотрудник с минимальной зарплатой по отделу №" + department + " - " + employeeMinSalaryInDepartment + " " + minSalaryDepartment +
                             " \nСредняя сумма затрат на зарплату по отделу №" + department + " - " + avgSalaryDepartment);

        System.out.println("Печать всех данных всех сотрудников отдела №" +department+", кроме номера отдела.");
        printEmployeesDepartment (employees, department);

    }



    private static void printEmployeesDepartment(EmployeeBook[] employees, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println( employees[i].getId() + " " +employees[i].getEmployee() + " " +employees[i].getSalary());
            }

        }

    }


    private static void taskLiteOne(EmployeeBook[] employees) {

        float sumSalary = 0;
        float maxSalary = 0;
        String employeeMaxSalary = "";
        float minSalary = employees[0].getSalary();
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

        float avgSalary = (float) sumSalary / employees.length;
        System.out.println("Средняя зарплата - " + avgSalary);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getEmployee());
        }
    }

    private static void taskLiteTwo(EmployeeBook[] employees) {
        float totalSalary = sumSalary(employees);
        System.out.println("Сумма затрат в месяц: "+totalSalary);
        float maxSalary = maxSalary(employees);
        float minSalary = minSalary(employees);
        String employeeMaxSalary = employeeAnySalary(employees, maxSalary);
        String employeeMinSalary = employeeAnySalary(employees, minSalary);
        float avgSalary = totalSalary/employees.length;



        System.out.println ("Сотрудник с максимальной зарплатой - "+employeeMaxSalary+   " - " + maxSalary +
                "\nСотрудник с минимальной зарплатой - "+ employeeMinSalary + " - " +minSalary);

        System.out.println("Средняя зарплата - " + avgSalary);
    }


    private static String employeeAnySalary(EmployeeBook[] arr, float salary) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() == salary) {
                return arr[i].getEmployee();
            }
        }
        return "";
    }

    private static float maxSalary(EmployeeBook[] arr) {
        float element = 0.0f;
        for (int i = 0; i < arr.length; i++) {
            if (element < arr[i].getSalary()) {
                element = arr[i].getSalary();
            }
        }
        return element;
    }

    private static float minSalary(EmployeeBook[] arr) {
        float element = arr[0].getSalary();
        for (int i = 0; i < arr.length; i++) {
            if (element > arr[i].getSalary()) {
                element = arr[i].getSalary();
            }
        }
        return element;
    }

    private static int  minSalaryInDepartment(EmployeeBook[] arr, int department) {
        int element = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department) {
                element = arr[i].id-1;
            }
        }
        return element;
    }


    private static float sumSalary(EmployeeBook[] arr) {
       float slr = 0;
        for (int i = 0; i < arr.length; i++) {
            slr = slr + arr[i].getSalary();
        }
        return slr;
    }




    public static void addEmployeesToArray(Object[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int department = randomNumber(5,1);
            float salary= rnd.nextInt(100_000) + 50_000f;
            EmployeeBook employee = new EmployeeBook("Петров Петр Петрович"+i, department, salary);
            arr[i] = employee;
            System.out.println(employee);
        }
    }

    private static int randomNumber(int i, int j) {
        Random rnd = new Random();
        return rnd.nextInt(i)+j;

    }

}