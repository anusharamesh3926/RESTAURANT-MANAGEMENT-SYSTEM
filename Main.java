import java.time.LocalDateTime;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Restaurant Management System ===\n");

        // LVTI demonstration
        var restaurant = new Restaurant("The Java Bistro", "123 Code Street");
        restaurant.displayInfo();

        // Records demonstration
        MenuItem appetizer = new MenuItem("Spring Rolls", 8.99, MenuCategory.APPETIZER);
        MenuItem mainCourse = new MenuItem("Grilled Salmon", 24.99, MenuCategory.MAIN_COURSE);
        MenuItem dessert = new MenuItem("Chocolate Cake", 12.50, MenuCategory.DESSERT);

        restaurant.addMenuItem(appetizer);
        restaurant.addMenuItem(mainCourse);
        restaurant.addMenuItem(dessert);

        // Polymorphism demonstration
        Employee chef = new Chef("Gordon", "C001", 5000.0, "Italian");
        Employee waiter = new Waiter("Sarah", "W001", 2500.0, 5);
        Employee manager = new Manager("John", "M001", 6000.0, "Operations");

        restaurant.addEmployee(chef);
        restaurant.addEmployee(waiter);
        restaurant.addEmployee(manager);

        System.out.println("\n=== Employee Information ===");
        restaurant.displayEmployees();

        Customer customer = new Customer("Alice", "alice@email.com", "555-1234");

        // Exception handling demonstration
        try {
            Reservation reservation = restaurant.createReservation(
                    customer,
                    LocalDateTime.now().plusDays(1),
                    4,
                    TableType.STANDARD);
            System.out.println("\n" + reservation);
        } catch (ReservationException e) {
            System.err.println("Reservation failed: " + e.getMessage());
        }

        // Varargs demonstration
        Order order = new Order("ORD001", customer);
        order.addItems(appetizer, mainCourse, dessert);

        System.out.println("\n=== Order Details ===");
        System.out.println(order);
        System.out.println("Total: $" + order.calculateTotal());

        // Lambda and Predicate demonstration
        System.out.println("\n=== Filtering Menu Items ===");
        filterAndDisplayItems(restaurant, item -> item.price() > 10.0, "Items over $10");
        filterAndDisplayItems(restaurant, item -> item.category() == MenuCategory.MAIN_COURSE,
                "Main Courses");

        // Method reference demonstration
        System.out.println("\n=== Menu Items (using method reference) ===");
        restaurant.getMenuItems().forEach(System.out::println);

        // Switch expression with pattern matching (Java 21)
        System.out.println("\n=== Employee Bonus Calculation ===");
        for (Employee emp : restaurant.getEmployees()) {
            double bonus = calculateBonus(emp);
            System.out.printf("%s (%s) bonus: $%.2f%n",
                    emp.getName(), emp.getClass().getSimpleName(), bonus);
        }

        // Sealed interface demonstration with pattern matching
        System.out.println("\n=== Payment Processing ===");
        processPayment(new CreditCardPayment("1234-5678-9012-3456", "12/25"),
                order.calculateTotal());
        processPayment(new CashPayment(100.0), order.calculateTotal());
        processPayment(new DigitalWalletPayment("alice@wallet.com", "PayPal"),
                order.calculateTotal());

        // Custom immutable type demonstration
        Address restaurantAddress = new Address("123 Code Street", "Tech City",
                "TC", "12345");
        System.out.println("\n=== Restaurant Address ===");
        System.out.println(restaurantAddress);
        System.out.println("Full address: " + restaurantAddress.getFullAddress());
    }

    // Lambda with Predicate - demonstrates 'effectively final' concept
    private static void filterAndDisplayItems(Restaurant restaurant,
            Predicate<MenuItem> predicate,
            String description) {
        System.out.println(description + ":");
        // 'restaurant' is effectively final (not modified after initialization)
        restaurant.getMenuItems().stream()
                .filter(predicate)
                .forEach(item -> System.out.println("  - " + item));
    }

    // Pattern matching with switch expression (Java 21 feature)
    private static double calculateBonus(Employee employee) {
        // Using instanceof pattern matching instead of switch for compatibility
        if (employee instanceof Chef) {
            Chef c = (Chef) employee;
            return c.getSalary() * 0.15;
        } else if (employee instanceof Manager) {
            Manager m = (Manager) employee;
            return m.getSalary() * 0.20;
        } else if (employee instanceof Waiter) {
            Waiter w = (Waiter) employee;
            return w.getSalary() * 0.10;
        } else {
            return 0.0;
        }
    }

    // Pattern matching with sealed interface (Java 21 feature)
    private static void processPayment(Payment payment, double amount) {
        String result;

        if (payment instanceof CreditCardPayment) {
            CreditCardPayment cc = (CreditCardPayment) payment;
            result = String.format("Processing credit card payment of $%.2f for card ending in %s",
                    amount, cc.cardNumber().substring(cc.cardNumber().length() - 4));
        } else if (payment instanceof CashPayment) {
            CashPayment cash = (CashPayment) payment;
            double change = cash.amountTendered() - amount;
            result = String.format("Cash payment received. Change: $%.2f", change);
        } else if (payment instanceof DigitalWalletPayment) {
            DigitalWalletPayment dw = (DigitalWalletPayment) payment;
            result = String.format("Processing %s payment of $%.2f for %s",
                    dw.provider(), amount, dw.email());
        } else {
            result = "Unknown payment type";
        }

        System.out.println(result);
    }
}