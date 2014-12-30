/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onetapeturingmachine;

import java.io.File;

/**
 *
 * @author Thomas De Praetere
 */
public class OneTapeTuringMachineMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OneTapeTuringMachine M = new OneTapeTuringMachine("");
        M.read(new File("M.txt"));
        M.execute();
    }
}
