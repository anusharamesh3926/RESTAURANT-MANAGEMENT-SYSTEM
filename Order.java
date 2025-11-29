import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private List<MenuItem> items;
    private LocalDateTime orderTime;
    private OrderStatus status;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
    }

    public void addItems(MenuItem... menuItems) {
        items.addAll(Arrays.asList(menuItems));
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.price();
        }
        return total;
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(items);
    }

    public MenuItem[] getItemsArray() {
        return items.toArray(new MenuItem[0]);
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("Items:\n");
        for (MenuItem item : items) {
            sb.append("  - ").append(item.name()).append(": ")
                    .append(item.getFormattedPrice()).append("\n");
        }
        return sb.toString();
    }
}