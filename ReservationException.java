public class ReservationException extends Exception {
    private String errorCode;

    public ReservationException(String message) {
        super(message);
    }

    public ReservationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ReservationException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorCode() {
        return errorCode;
    }
}