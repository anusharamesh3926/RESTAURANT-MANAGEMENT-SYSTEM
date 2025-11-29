public class Waiter extends Employee {
    private int tablesAssigned;

    public Waiter(String name, String employeeId, double salary, int tablesAssigned) {
        super(name, employeeId, salary);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Waiter: %s (ID: %s), Tables: %d, Salary: $%.2f%n",
                getName(), getEmployeeId(), tablesAssigned, getSalary());
    }

    public int getTablesAssigned() {
        return tablesAssigned;
    }
}