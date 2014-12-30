/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onetapeturingmachine.Tape;

/**
 *
 * @author Thomas De Praetere
 */
public class TapeItem<T> {

    private TapeItem<T> previous;
    private TapeItem<T> next;
    private T item;

    public TapeItem(T item) {
        this.item = item;
    }

    public TapeItem<T> getPrevious() {
        return previous;
    }

    public void setPrevious(TapeItem<T> previous) {
        this.previous = previous;
    }

    public TapeItem<T> getNext() {
        return next;
    }

    public void setNext(TapeItem<T> next) {
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
