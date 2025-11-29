public enum MenuCategory {
    APPETIZER("Appetizer", 1),
    MAIN_COURSE("Main Course", 2),
    DESSERT("Dessert", 3),
    BEVERAGE("Beverage", 4),
    SIDE_DISH("Side Dish", 5);

    private final String displayName;
    private final int order;

    MenuCategory(String displayName, int order) {
        this.displayName = displayName;
        this.order = order;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getOrder() {
        return order;
    }

    public boolean isMainItem() {
        return this == MAIN_COURSE || this == APPETIZER;
    }
}