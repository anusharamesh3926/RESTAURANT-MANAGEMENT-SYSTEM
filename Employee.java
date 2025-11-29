public abstract class Employee {
    private String name;
    private String employeeId;
    private double salary;

    public Employee(String name, String employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public abstract void displayInfo();

    public double calculateMonthlyPay() {
        return salary / 12;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }
}