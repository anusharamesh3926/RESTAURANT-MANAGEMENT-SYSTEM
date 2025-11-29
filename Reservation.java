import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private String reservationId;
    private Customer customer;
    private LocalDateTime dateTime;
    private int partySize;
    private TableType tableType;
    private ReservationStatus status;

    public Reservation(String reservationId, Customer customer, LocalDateTime dateTime,
            int partySize, TableType tableType) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.dateTime = dateTime;
        this.partySize = partySize;
        this.tableType = tableType;
        this.status = ReservationStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = ReservationStatus.CANCELLED;
    }

    public void complete() {
        this.status = ReservationStatus.COMPLETED;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getPartySize() {
        return partySize;
    }

    public TableType getTableType() {
        return tableType;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("Reservation %s: %s for %d people at %s (%s table) - %s",
                reservationId, customer.getName(), partySize,
                dateTime.format(formatter), tableType.getName(), status);
    }
}