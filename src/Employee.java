import java.util.Objects;

// 1. Создание класса Employee с информацией о Ф.И.О., отделе и зарплате.
public class Employee {
    private final String surname;
    private final String name;
    private final String patronymic;
    private int department;
    private int salary;
    // 2. Добавление статистической переменной-счетчика, которая отвечает за id.
    private static int idCounter = 1;
    // 3. Добавление в класс Employee поле id.
    private final int id;

    public Employee (String surname, String name, String patronymic, int department, int salary) {
        id = idCounter++;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
    }

    // 4. Скрытие прямого доступа к полям класса Employee, добавление возможности получать значения полей (геттеры) и устанавливать значение полей отдела и зарплаты (сеттеры).
    public String getSurname () {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
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
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Employee salary = (Employee) o;
        return this.salary.equals(salaries.salary) && this.fullName.equals(salaries.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, department, salary, id);
    }

    // 6. Реализация метода вывода информации о сотруднике.
    @Override
    public String toString () {
        return "Сотрудник № " + idCounter + " Ф.И.О.: " + surname + name + patronymic + " работает в отделе №" +
                department + " и полуает зарплату " + salary + " рублей";
    }

    // Отдельный метод для вывода имени и зарплаты
    public void printShortInfo () {
        System.out.println("Ф.И.О.: " + surname + name + patronymic + " зарплата - " + salary);
    }
}