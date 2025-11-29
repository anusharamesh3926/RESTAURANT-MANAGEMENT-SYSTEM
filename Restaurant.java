import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private List<MenuItem> menuItems;
    private List<Employee> employees;
    private List<Reservation> reservations;

    public Restaurant(String name) {
        this(name, "Unknown Address");
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.menuItems = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void addMenuItem(String name, double price, MenuCategory category) {
        menuItems.add(new MenuItem(name, price, category));
    }

    public void addMenuItems(MenuItem... items) {
        for (MenuItem item : items) {
            menuItems.add(item);
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Reservation createReservation(Customer customer, LocalDateTime dateTime,
            int partySize, TableType tableType)
            throws ReservationException {

        if (partySize <= 0) {
            throw new ReservationException("Party size must be positive");
        }

        if (partySize > 20) {
            throw new ReservationException("Party size exceeds maximum capacity");
        }

        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new ReservationException("Cannot make reservation in the past");
        }

        String reservationId = "RES" + (reservations.size() + 1);
        Reservation reservation = new Reservation(reservationId, customer, dateTime,
                partySize, tableType);
        reservations.add(reservation);
        return reservation;
    }

    public void displayInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Restaurant: ").append(name).append("\n");
        sb.append("Address: ").append(address).append("\n");
        sb.append("Menu Items: ").append(menuItems.size()).append("\n");
        sb.append("Employees: ").append(employees.size());
        System.out.println(sb.toString());
    }

    public void displayEmployees() {
        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }

    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(menuItems);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}