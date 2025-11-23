import java.util.Objects;

// 1. Создание класса Employee с информацией о Ф.И.О., отделе и зарплате.
public class Employee {
    private String fullName;
    private int department;
    private int salary;
    // 2. Добавление статистической переменной-счетчика, которая ривечает за id.
    private static int idCounter;
    private int id;

    public Employee (String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // 3. Добавление в класс Employee поля id.
    public Employee () {
        this.id = idCounter++;
    }

    // 4. Скрытие прямого доступа к полям класса Employee, добавление возможности получать значения полей (геттеры) и устанавливать значение полей отдела и зарплаты (сеттеры).

    public String getFullName () {
        return this.fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return salary;
    }

    public static int getIdCounter () {
        return idCounter;
    }

    public int getId () {
        return id;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Существуют отделы с 1 по 5");
        }
        this.department = department;
    }

    public void setSalary(int salary) {
        if (salary < 50 || salary > 450){
            throw new IllegalArgumentException("Несоответствующая зарплата");
        }
        this.salary = salary;
    }

    // 5. Реализация в классе Employee контракта equals.

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee salaries = (Employee) other;
        return salaries.equals(salaries.salary);
    }

    @Override
    public int hashCode () {
        return java.util.Objects.hash(salary);
    }
}
