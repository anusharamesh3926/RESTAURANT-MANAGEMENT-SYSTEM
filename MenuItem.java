public record MenuItem(String name, double price, MenuCategory category) {
    public MenuItem {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    public String getFormattedPrice() {
        return String.format("$%.2f", price);
    }

    public boolean isExpensive() {
        return price > 20.0;
    }
}