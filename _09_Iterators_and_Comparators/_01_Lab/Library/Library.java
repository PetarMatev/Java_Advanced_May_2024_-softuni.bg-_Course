package Java_Advanced_May_2024._09_Iterators_and_Comparators._01_Lab.Library;


import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    public Book[] getBooks() {
        return this.books;
    }

    private class LibIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < getBooks().length;
        }

        @Override
        public Book next() {
            return getBooks()[counter++];
        }
    }
}
