public sealed interface Payment
        permits CreditCardPayment, CashPayment, DigitalWalletPayment {

    default String getPaymentType() {
        return this.getClass().getSimpleName();
    }

    static Payment createCashPayment(double amount) {
        return new CashPayment(amount);
    }

    default String getFormattedInfo() {
        return "Payment Type: " + getPaymentType();
    }
}