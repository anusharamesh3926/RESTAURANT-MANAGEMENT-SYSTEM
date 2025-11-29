public class Manager extends Employee {
    private String department;

    public Manager(String name, String employeeId, double salary, String department) {
        super(name, employeeId, salary);
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Manager: %s (ID: %s), Department: %s, Salary: $%.2f%n",
                getName(), getEmployeeId(), department, getSalary());
    }

    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay() + 1000;
    }

    public String getDepartment() {
        return department;
    }
}