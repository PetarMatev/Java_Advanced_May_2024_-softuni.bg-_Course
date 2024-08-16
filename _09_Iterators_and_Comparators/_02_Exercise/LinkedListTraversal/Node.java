package Java_Advanced_May_2024._09_Iterators_and_Comparators._02_Exercise.LinkedListTraversal;


public class Node<T extends Comparable<T>> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}