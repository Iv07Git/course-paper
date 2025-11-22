public class Employee {
    private String fullName;
    private int department;
    private int salary;
    private static int idCounter;
    private int id;

    public Employee (String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public Employee () {
        this.id = idCounter++;
    }

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
            throw new IllegalArgumentException("Существуют отделы от 1 до 5");
        }
        this.department = department;
    }

    public void setSalary(int salary) {
        if (salary < 50 || salary > 450){
            throw new IllegalArgumentException("Несоответствующая зарплата");
        }
        this.salary = salary;
    }

    @Override
    public boolean equals(Object other) {
        if () {

        }
    }
}
