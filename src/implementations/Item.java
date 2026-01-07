package implementations;

import java.time.LocalDate;
import java.util.Objects;

public class Item {
    private final Product product;
    private final LocalDate date;

    public Item(Product product, LocalDate date) {
        this.product = product;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return product == item.product && Objects.equals(date, item.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, date);
    }

    @Override
    public String toString() {
        return this.product.toString() + "\n" +
                "Дата изготовления: " + this.date.toString();
    }
}
