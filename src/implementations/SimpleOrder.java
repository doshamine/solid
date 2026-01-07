package implementations;

import interfaces.Cart;
import interfaces.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleOrder implements Order {
    private final LocalDateTime time = LocalDateTime.now();
    private final String address;
    private final Cart<Item> cart;

    public SimpleOrder(Cart<Item> cart, String address) {
        this.cart = cart;
        this.address = address;
    }

    @Override
    public void show() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy в HH:mm:ss");
        System.out.println("Ваш заказ создан " + time.format(formatter));
        cart.show();
        System.out.println("Заказ готовится к отправке по адресу " + address);
    }
}
