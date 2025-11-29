public class Chef extends Employee {
    private String specialization;

    public Chef(String name, String employeeId, double salary, String specialization) {
        super(name, employeeId, salary);
        this.specialization = specialization;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Chef: %s (ID: %s), Specialization: %s, Salary: $%.2f%n",
                super.getName(), super.getEmployeeId(), specialization, super.getSalary());
    }

    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay() + 500;
    }

    public String getSpecialization() {
        return specialization;
    }
}