// 7. Создание класса EmployeeBook с полем типа Employee[10], выполняющее роль хранилища для записей о сотрудниках.
public class EmployeeBook {

    private final static Random RANDOM = new Random();
    private final static String [] SURNAME ("Андреев", "Иванов", "Олегов", "Кириллов", "Александров", "Вадимов", "Алексеев");
    private final static String [] NAME ("Андрей", "Иван", "Олег", "Кирилл", "Александр", "Вадим", "Алексей");
    private final static String [] PATRONYMIC ("Андреевич", "Иванович", "Олегович", "Кириллович", "Александрович", "Вадимович", "Алексеевич");

    private static Employee[] EMPLOYEES = new Employee[10];

    // 8. Создать методы, которые взаимодействуют с массивом пункта 7 и возвращают результат:
    // - Получить список всех сотрудников со всеми данными о них, вывести в консоль значения всех полей, кроме Null
    public static boolean listAllEmployee(Employee employee) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAME [RANDOM.nextInt(0, SURNAME().length)] + " " +
                NAME [RANDOM.nextInt(0, NAME().length)] + " " +
                PATRONYMIC [RANDOM.nextInt(0, PATRONYMIC.length)];
            EMPLOYEES[i] = new Employee (fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50000, 450000))
        }
    }

    public void printAllEmployee() {
        for (Employee employee : EMPLOYEE) {
            if (employee == null) {
                break;
            }
            System.out.println(employee.toString());
        }
    }
}

// - Подсчитать среднее значение зарплат.
    public double averageSalary() {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            int salary = employee.getSalary();
            if (salary != null) {
                sum += salary;
            }
            count++;
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }

    public void printTaxes(String taxType) {
        for (Employee employee : employees) {
            if (employee == null)
                break;
            int salary = employee.getSalary();
            if (salary == null)
                continue;

            double taxPercent;
            switch (taxType.toUpperCase()) {
                case "PROPORYIONAL":
                    taxPercent = 13;
                    break;
                case "PROGRESSIVE":
                    if (salary <= 150) {
                        taxPercent = 13;
                    } else if (salary <= 350) {
                        taxPercent = 17;
                    } else {
                        taxPercent = 21;
                    }
                    break;
                default:
                    System.out.println("Неверный тип расчета налогов: " + taxType);
                    return;
            }

            double taxAmount = salary * taxPercent / 100;
            System.out.printf("Employee: %s, Salary: %.2f, Tax (%s): %.2f%n",
                    employee.toString(), salary, taxType.toUpperCase(), taxAmount);
        }
    }

    public void indexSalaryByDepartment(int departmentNumber, double percent) {
        for (Employee employee : employees) {
            if (employee == null)
                break;
            if (!employee.getDepartment(.equals(departmentNumber)))
            continue;
            double oldSalary = employee.getSalary();
            if (oldSalary == null)
                continue;
            double newSalary = oldSalary + oldSalary * percent / 100;
            employee.setSalary(newSalary);
        }
    }
    public void findFirstEmployeeByDepartmentAndSalary(int departmentNumber, double salaryThreshold) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee == null)
                break;
            if (employee.getDepartment().equals(departmentNumber) && employee.getSalary() > salaryThreshold) {
                System.out.printf("First employee in department %d with salary > %.2f at position %d:%n", departmentNumber, salaryThreshold, i + 1);
                employee.printShortInfo();
                break;
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(double wage, int employeeNumber) {
        int count = 0;
        int index = 0;
        while (index < employees.length && count < employeeNumber) {
            Employee employee = employees[index];
            if (employee == null) break;
            if (employee.getSalary() < wage) {
                employee.printShortInfo();
                count++;
            }
            index++;
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee == null) break;
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}