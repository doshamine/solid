import implementations.*;
import interfaces.Delivery;
import interfaces.Order;
import interfaces.Stock;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private enum ItemParameters {
        NAME, DATE, AMOUNT
    }

    public static void main(String[] args) {
        Stock<Item> stock = new SimpleStock();

        System.out.println("Добавьте товары в корзину в формате <имя> <гггг-мм-дд> <количество>");
        System.out.println("Для завершения заполнения корзины введите done");

        Scanner scanner = new Scanner(System.in);
        SimpleCart cart = new SimpleCart();
        while (true) {
            stock.show();
            System.out.print("> ");
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("done")) {
                break;
            }

            if (input.length != ItemParameters.values().length) {
                System.out.println("Данные введены неверно");
                continue;
            }

            String name = input[ItemParameters.NAME.ordinal()];
            String date = input[ItemParameters.DATE.ordinal()];
            int amount = Integer.parseInt(input[ItemParameters.AMOUNT.ordinal()]);

            LocalDate parsedDate;
            try {
                parsedDate = LocalDate.parse(date);
            } catch (Exception e) {
                System.out.println("Неверный формат даты: " + e.getMessage());
                continue;
            }

            Item item = new Item(
                Product.ofLabel(name), parsedDate
            );

            if (!stock.change(item, -amount)) {
                System.out.println("Ошибка при добавлении товара");
                continue;
            }

            cart.change(item, amount);
        }

        System.out.println("Создаем заказ");
        System.out.print("Введите адрес доставки: ");
        String address = scanner.nextLine();
        Order order = new SimpleOrder(cart, address);

        while (true) {
            System.out.println("Выберите способ доставки:");
            for (DeliveryMethod deliveryMethod : DeliveryMethod.values()) {
                System.out.println(deliveryMethod.ordinal() + " " + deliveryMethod);
            }
            System.out.print("Ваш выбор (введите номер): ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice >= DeliveryMethod.values().length) {
                System.out.println("Недопустимое значение");
                continue;
            }
            Delivery delivery = new SimpleDelivery(DeliveryMethod.values()[choice]);
            delivery.deliver(order);
            break;
        }
    }
}
