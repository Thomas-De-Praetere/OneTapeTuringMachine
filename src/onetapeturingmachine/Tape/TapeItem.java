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

    private TapeItem<T> L;
    private TapeItem<T> R;
    private T item;

    public TapeItem(T item) {
        this.item = item;
    }

    public TapeItem<T> getL() {
        return L;
    }

    public void setL(TapeItem<T> L) {
        this.L = L;
    }

    public TapeItem<T> getR() {
        return R;
    }

    public void setR(TapeItem<T> R) {
        this.R = R;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
