# Примеры применения принципов
## Принцип избегания магических чисел
Для обеспечения корректного ввода данных о товаре и успешного парсинга строки с параметрами, введенными пользователем, создается [перечисление ItemParameters](https://github.com/doshamine/solid/main/src/Main.java#L10-L12).
Далее перечисление применяется для [проверки количества параметров](https://github.com/doshamine/solid/main/src/Main.java#L38-L41) и [индексации массива параметров](https://github.com/doshamine/solid/main/src/Main.java#L43-L45).

## Принцип DRY
В реализации метода [show в классе SimpleOrder](https://github.com/doshamine/solid/main/src/implementations/SimpleOrder.java#L18-L24) для вывода информации о товарах в заказе используется уже готовый метод класса [Cart](https://github.com/doshamine/solid/main/src/interfaces/Cart.java).

## Принцип единственной ответственности
Функции заполнения корзины и организации доставки разделены на два разных класса: соответственно [Cart](https://github.com/doshamine/solid/main/src/interfaces/Cart.java) и [Delivery](https://github.com/doshamine/solid/main/src/interfaces/Delivery.java).

## Принцип подстановки Лисков
Интерфейс [Delivery](https://github.com/doshamine/solid/main/src/interfaces/Delivery.java) имеет метод deliver, который принимает объект любого класса, наследующего от интерфейса [Order](https://github.com/doshamine/solid/main/src/interfaces/Order.java). Действие с любым из таких объектов ограничивается вызовом методов, указанных в интерфейсе Order (метод show), вне зависимости от реализации класса.

## Принцип разделения интерфейсов
Интерфейсы [Changeable](https://github.com/doshamine/solid/main/src/interfaces/Changeable.java) и [Showing](https://github.com/doshamine/solid/main/src/interfaces/Showing.java) не объединены, поскольку они ответственны за разное поведение того или иного класса. Несмотря на то что [Stock](https://github.com/doshamine/solid/main/src/interfaces/Stock.java) и [Cart](https://github.com/doshamine/solid/main/src/interfaces/Cart.java) наследуют от обоих интерфейсов, [Order](https://github.com/doshamine/solid/main/src/interfaces/Order.java) наследует только от Showing.

## Принцип инверсии зависимостей
Одним из полей класса [SimpleOrder](https://github.com/doshamine/solid/main/src/implementations/SimpleOrder.java) является объект, реализующий интерфейс [Cart](https://github.com/doshamine/solid/main/src/interfaces/Cart.java). Таким образом, использование этого поля не зависит от особенностей реализации конкретного класса.