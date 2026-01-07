package implementations;

public enum Product {
    CHEESE("сыр"), BREAD("хлеб"),
    MILK("молоко"), CHOCOLATE("шоколад");

    private final String label;

    Product(String label) {
        this.label = label;
    }

    public static Product ofLabel(String label) {
        for (Product p : Product.values()) {
            if (p.label.equals(label)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return label;
    }
}
