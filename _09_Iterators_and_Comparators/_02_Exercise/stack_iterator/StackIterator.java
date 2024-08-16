package Java_Advanced_May_2024._09_Iterators_and_Comparators._02_Exercise.stack_iterator;

import java.util.Iterator;

public class StackIterator<T> implements Iterable<Integer> {

    private Integer[] elements;
    private int internalIndex;

    public StackIterator() {
        this.elements = new Integer[16];
        this.internalIndex = 0;
    }


    public void push(int element) {
        this.elements[this.internalIndex++] = element;
    }

    public Integer pop() {
        if (this.internalIndex == 0) {
            throw new IllegalStateException("No elements");
        }

        // remove the last index;
        Integer element = this.elements[this.internalIndex - 1];
        // we make the element null
        this.elements[this.internalIndex - 1] = null;
        // reduce the internal index because we have removed 1;
        this.internalIndex--;
        return element;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            // intrnal index as we run frorm 0, 1, 2, 3, 4 (we go back from the end)
            int index = internalIndex - 1;

            @Override
            public boolean hasNext() {
                return this.index >= 0;
            }

            @Override
            public Integer next() {
                // reduce each time from 5, 4, 3, 2, 1 backwards
                return elements[this.index--];
            }
        };
    }
}
