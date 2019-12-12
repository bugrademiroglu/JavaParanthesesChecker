import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * @author Bugra Demiroglu
 * @version 1.0
 *
 *Date: 15.11.2019
 * Student ID: 041601016
 *
 *
 * Stack class is for storing int elements. That Stack class implemented by using array.
 */

/**
 *
 * @param <Item> the item is a generic for stack type.
 */
public class myStack<Item> implements Iterable<Item> {
    private Item[] a; // array of items
    private int n; // number of elements on stack
    public myStack() {
        a = (Item[]) new Object[2];
        n = 0;


    }

    /**
     *n as a size of the stack
     * @return n as a size of the stack
     */
    public boolean isEmpty() { return n == 0; }

    /**
     *n as a size of the stack
     * @return n as a size of the stack
     */
    public int size() { return n; }

    /**
     *getting int value to resizing the stack.
     * @param capacity getting int value to resizing the stack.
     */
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];


        }



        a = temp;


    }

    /**
     *Pusing item into the stack
     * @param item Pusing item into the stack
     */
    public void push(Item item) {
        if (n == a.length) {
            resize(2 * a.length); // double size of array if necessary
            System.out.print("\n\n << stack doubled >> \n\n");



        }
        a[n++] = item; // add item


    }

    /**
     *pushed value from the stack
     * @return pushed value from the stack
     */
    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item item = a[n - 1];
        a[n - 1] = null; // to avoid loitering
        n--;
// shrink size of array if necessary
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
        return item;



    }

    /**
     *last value from the stack without removing
     * @return last value from the stack without removing
     */
    public Item peek() {

        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        return a[n - 1];


    }

    /**
     * Printing the stack
     */
    public void Print() {
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println(a[i]);
        }

        }




    public Iterator<Item> iterator() {

        return new ReverseArrayIterator();

    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i;
        public ReverseArrayIterator() { i = n - 1; }

        public boolean hasNext() { return i >= 0; }

        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {

            if (!hasNext())
                throw new NoSuchElementException();
            return a[i--];


        }


    }


}