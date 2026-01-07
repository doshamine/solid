package implementations;

import interfaces.Cart;

import java.util.HashMap;
import java.util.Map;

public class SimpleCart implements Cart<Item> {
    private final Map<Item, Integer> amounts = new HashMap<>();

    public SimpleCart() {
    }

    @Override
    public void show() {
        System.out.println("Содержимое заказа:");
        for (Map.Entry<Item, Integer> entry : amounts.entrySet()) {
            Item item = entry.getKey();
            System.out.println("Товар: " + item);
            int amount = entry.getValue();
            System.out.println("Количество: " + amount + "\n");
        }
    }

    @Override
    public boolean change(Item item, int difference) {
        if (amounts.containsKey(item)) {
            int newAmount = Math.max(amounts.get(item) + difference, 0);
            amounts.put(item, newAmount);
        } else {
            amounts.put(item, Math.max(difference, 0));
        }

        return true;
    }
}
