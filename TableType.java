public class TableType {
    private final String name;
    private final int capacity;

    protected TableType(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public static TableType STANDARD = new TableType("Standard", 4);
    public static TableType VIP = new TableType("VIP", 6);
    public static TableType OUTDOOR = new TableType("Outdoor", 4);
}