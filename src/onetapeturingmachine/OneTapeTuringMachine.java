/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onetapeturingmachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import onetapeturingmachine.Delta.DeltaOne;
import onetapeturingmachine.Delta.DeltaTwo;
import onetapeturingmachine.Tape.Tape;

/**
 *
 * @author Thomas De Praetere
 */
public class OneTapeTuringMachine {

    private Set<String> Alphabeth;
    private Set<String> States;
    private String state;
    private Set<String> EndStates;
    private HashMap<DeltaOne, DeltaTwo> delta;
    private Tape tape;
    private String sep;

    public OneTapeTuringMachine(String sep) {
        States = new HashSet<>();
        EndStates = new HashSet<>();
        Alphabeth = new HashSet<>();
        delta = new HashMap<>();
        tape = new Tape();
        this.sep = sep;
    }

    public void read(File file) {
        try {
            Scanner sc = new Scanner(file);
            String nextLine = sc.nextLine();
            initialize(nextLine.split(" "));
            while (sc.hasNextLine()) {
                initDelta(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OneTapeTuringMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void execute() {
        while (!EndStates.contains(state)) {
            step();
            tape.print(sep);
        }
    }

    private void step() {
        String A = tape.get();
        DeltaTwo get = delta.get(new DeltaOne(state, A));
        if (Alphabeth.contains(get.getA()) && States.contains(get.getZ())) {
            state = get.getZ();
            tape.execute(get.getA(), get.getD());
        } else {
            throw new IllegalArgumentException("New letter or state not in alphabeth or states.");
        }
    }
    //Eerst states dan startstate dan endstates dan alphabet gescheiden door :
    //States : startstate : endstate : alphabet : Start

    private void initialize(String[] split) {
        int i = 0;
        while (!split[i].equals(":")) {
            States.add(split[i]);
            i++;
        }
        i++;
        while (!split[i].equals(":")) {
            States.add(split[i]);
            state = split[i];
            i++;
        }
        i++;
        while (!split[i].equals(":")) {
            EndStates.add(split[i]);
            i++;
        }
        i++;
        while (!split[i].equals(":") && i < split.length) {
            Alphabeth.add(split[i]);
            i++;
        }
        i++;
        int j = i;
        String[] start = new String[split.length - i - 1];
        while (!split[i].equals(":") && i < split.length) {
            start[i - j] = split[i];
            i++;
        }
        tape.setStart(start);
    }

    //Delta van vorm z a z a d
    private void initDelta(String nextLine) {
        String[] split = nextLine.split(" ");
        delta.put(new DeltaOne(split[0], split[1]), new DeltaTwo(split[2], split[3], split[4]));
    }
}
