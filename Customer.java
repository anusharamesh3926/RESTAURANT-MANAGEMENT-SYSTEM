import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final String email;
    private final String phone;
    private final List<Order> orderHistory;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.orderHistory = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public List<Order> getOrderHistory() {
        return new ArrayList<>(orderHistory);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}