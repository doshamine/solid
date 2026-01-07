package interfaces;

public interface Changeable<T> {
    boolean change(T item, int difference);
}
