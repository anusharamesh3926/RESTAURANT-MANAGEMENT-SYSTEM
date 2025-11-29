public record CashPayment(double amountTendered) implements Payment {
    public CashPayment {
        if (amountTendered < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}