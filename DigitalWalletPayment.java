public record DigitalWalletPayment(String email, String provider)
        implements Payment {

    public DigitalWalletPayment {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
}