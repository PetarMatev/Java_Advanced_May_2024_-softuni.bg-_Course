package Java_Advanced_May_2024._08_Generics._01_Lab.GenericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left.compareTo(right) > 0) {
            return left;
        }
        if (left.compareTo(right) < 0) {
            return right;
        }
        return null;
    }
}