import java.util.Objects;

// 1. Создание класса Employee с информацией о Ф.И.О., отделе и зарплате.
public class Employee {
    private String fullName;
    private int department;
    private int salary;
    // 2. Добавление статистической переменной-счетчика, которая отвечает за id.
    private static int idCounter;
    // 3. Добавление в класс Employee поле id.
    private int id;

    public Employee (String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = idCounter++;
    }

    // 4. Скрытие прямого доступа к полям класса Employee, добавление возможности получать значения полей (геттеры) и устанавливать значение полей отдела и зарплаты (сеттеры).
    public String getFullName () {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
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

    // 5. Реализация контракта equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

    // 6. Реализация метода вывода информации о сотруднике.
    @Override
    public String toString () {
        return "Сотрудник № " + idCounter + ": Ф.И.О. " + fullName + " работает в отделе №" +
                department + " и полуает зарплату " + salary + " рублей";
    }

    // Отдельный метод для вывода имени и зарплаты
    public void printShortInfo () {
        System.out.println("Ф.И.О.: " + fullName + " зарплата - " + salary);
    }
}
