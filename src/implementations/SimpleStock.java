package implementations;

import interfaces.Stock;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SimpleStock implements Stock<Item> {
    Map<Item, Integer> amounts = new HashMap<>();

    public SimpleStock() {
        amounts.put(
                new Item(
                        Product.BREAD, LocalDate.of(2025, 12, 31)
                ), 20
        );
        amounts.put(
                new Item(
                        Product.CHEESE, LocalDate.of(2025, 11, 30)
                ), 30
        );
        amounts.put(
                new Item(
                        Product.CHOCOLATE, LocalDate.of(2025, 10, 21)
                ), 15
        );
        amounts.put(
                new Item(
                        Product.MILK, LocalDate.of(2025, 12, 31)
                ), 6
        );
    }

    @Override
    public void show() {
        System.out.println("Список доступных товаров:");
        for (Map.Entry<Item, Integer> entry : amounts.entrySet()) {
            Item item = entry.getKey();
            System.out.println("Товар: " + item);
            int amount = entry.getValue();
            System.out.println(amount + " штук\n");
        }
    }

    @Override
    public boolean change(Item item, int difference) {
        if (!amounts.containsKey(item)) {
            System.out.println("Такого товара нет");
            return false;
        }

        if (amounts.get(item) + difference < 0) {
            System.out.println("Максимальное количество данного товара: " + amounts.get(item));
            return false;
        }
        amounts.put(item, amounts.get(item) + difference);

        if (amounts.get(item) == 0) {
            amounts.remove(item);
        }

        return true;
    }
}
