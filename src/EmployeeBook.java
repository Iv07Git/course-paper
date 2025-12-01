// 7. Создание класса EmployeeBook с полем типа Employee[10], выполняющее роль хранилища для записей о сотрудниках.
public class EmployeeBook {
    private static Employee[] employees = new Employee[10];

    // 8. Создать методы, которые взаимодействуют с массивом пункта 7 и возвращают результат: - Получить список всех сотрудников со всеми данными о них, вывести в консоль значения всех полей, кроме Null
    public static boolean listAllEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public void printAllEmployee() {
        for (Employee employee : employees) {
            if (employee == null) {
                System.out.println(employee.toString());
            }
        }
    }

    // Подсчитать среднее значение зарплат.

}