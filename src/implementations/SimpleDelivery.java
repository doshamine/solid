package implementations;

import interfaces.Delivery;
import interfaces.Order;

import java.util.Map;

public class SimpleDelivery implements Delivery {
    DeliveryMethod deliveryMethod;
    DeliveryStatus deliveryStatus;

    public SimpleDelivery(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
        this.deliveryStatus = DeliveryStatus.WAITING;
    }

    @Override
    public void deliver(Order order) {
        deliveryStatus = DeliveryStatus.IN_TRANSIT;
        System.out.println("Заказ в доставке");
        order.show();

        switch (deliveryMethod) {
            case ON_FOOT:
                System.out.println("доставлено пешком");
                deliveryStatus = DeliveryStatus.DELIVERED;
                break;

            case BICYCLE:
                System.out.println("доставлено на велосипеде");
                deliveryStatus = DeliveryStatus.DELIVERED;
                break;

            case AUTOMOBILE:
                System.out.println("доставлено на автомобиле");
                deliveryStatus = DeliveryStatus.DELIVERED;
                break;

            default:
                System.out.println("Незнакомый способ доставки");
        }
    }
}
