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

        float avgSalary = (float) sumSalary / employees.length;
        System.out.println("Средняя зарплата - " + avgSalary);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getEmployee());
        }
    }

    private static void taskLiteTwo() {
        int count = 10;
        EmployeeBook[] employees = new EmployeeBook[count];
        addEmployeesToArray(employees);
        String[] name = new String[count];
        int[] salary = new int[count];

        for (int i = 0; i < employees.length; i++) {
            name[i] = employees[i].getEmployee();
            salary[i] = employees[i].getSalary();
        }
        int totalSalary = sumSalary(salary);
        System.out.println("Сумма затрат в месяц: "+totalSalary);
        int maxSalary = maxSalary(salary);
        int minSalary = minSalary(salary);
        String employeeMaxSalary = employeeAnySalary(employees, maxSalary);
        String employeeMinSalary = employeeAnySalary(employees, minSalary);
        float avgSalary = (float) totalSalary/employees.length;



        System.out.println ("Сотрудник с максимальной зарплатой - "+employeeMaxSalary+   " - " + maxSalary +
                "\nСотрудник с минимальной зарплатой - "+ employeeMinSalary + " - " +minSalary);

        System.out.println("Средняя зарплата - " + avgSalary);
    }


    private static String employeeAnySalary(EmployeeBook[] arr, int maxSalary) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() == maxSalary) {
                return arr[i].getEmployee();
            }
        }
        return "";
    }

    private static int maxSalary(int[] arr) {
        int element = 0;
        for (int i = 0; i < arr.length; i++) {
            if (element < arr[i]) {
                element = arr[i];
            }
        }
        return element;
    }

    private static int minSalary(int[] arr) {
        int element = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (element > arr[i]) {
                element = arr[i];
            }
        }
        return element;
    }


    private static int sumSalary(int[] arr) {
       int slr = 0;
        for (int i = 0; i < arr.length; i++) {
            slr = slr + arr[i];
        }
        return slr;
    }




    public static void addEmployeesToArray(Object[] arr) {
        int salary=100_000;
        for (int i = 0; i < arr.length; i++) {
            EmployeeBook employee = new EmployeeBook("Петров Петр Петрович"+i, 1+i, salary);
            arr[i] = employee;
            salary += salary;
            System.out.println(employee);
        }
    }


}