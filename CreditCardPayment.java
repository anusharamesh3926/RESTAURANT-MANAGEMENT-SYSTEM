public record CreditCardPayment(String cardNumber, String expiryDate)
        implements Payment {

    public CreditCardPayment {
        if (cardNumber == null || cardNumber.length() < 13) {
            throw new IllegalArgumentException("Invalid card number");
        }
    }
}