/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onetapeturingmachine.Tape;

/**
 *
 * @author Thomas De Praetere
 */
public class Tape {

    private TapeItem<String> head;

    public Tape() {
        head = new TapeItem<>("B");
    }

    private void go(String direction) {
        switch (direction) {
            case "R":
                if (head.getR() == null) {
                    TapeItem<String> r = new TapeItem<>("B");
                    head.setR(r);
                    r.setL(head);
                    head = r;
                } else {
                    head = head.getR();
                }
                break;
            case "L":
                if (head.getL() == null) {
                    TapeItem<String> l = new TapeItem<>("B");
                    head.setL(l);
                    l.setR(head);
                    head = l;
                } else {
                    head = head.getL();
                }
                break;
            case "N":
                break;
        }
    }

    public String get() {
        return head.getItem();
    }

    public void execute(String A, String D) {
        head.setItem(A);
        go(D);
    }

    public void setStart(String[] start) {
        head = new TapeItem<>(start[0]);
        TapeItem<String> prev = head;
        for (int i = 1; i < start.length; i++) {
            TapeItem<String> next = new TapeItem<>(start[i]);
            prev.setR(next);
            next.setL(prev);
            prev = next;
        }
    }

    public void print(String sep) {
        TapeItem<String> n = head;
        while (n.getL() != null) {
            n = n.getL();
        }
        TapeItem<String> l = n;
        while (l.getR() != null) {
            if (l == head) {
                System.out.print("v" + sep);
            } else {
                System.out.print(" " + sep);
            }
            l = l.getR();
        }
        if (l == head) {
            System.out.print("v" + sep);
        } else {
            System.out.print(" " + sep);
        }
        System.out.println("");
        l = n;
        while (l.getR() != null) {
            System.out.print(l.getItem() + sep);
            l = l.getR();
        }
        System.out.print(l.getItem() + sep);
        System.out.println("");
    }
}
