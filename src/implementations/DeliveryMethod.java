package implementations;

public enum DeliveryMethod {
    ON_FOOT("пешком"), BICYCLE("на велосипеде"),
    AUTOMOBILE("на машине");

    private final String label;

    DeliveryMethod(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
