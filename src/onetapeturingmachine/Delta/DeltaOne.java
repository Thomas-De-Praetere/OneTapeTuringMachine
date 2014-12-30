/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onetapeturingmachine.Delta;

import java.util.Objects;

/**
 *
 * @author Thomas De Praetere
 */
public class DeltaOne {

    private String z;
    private String A;

    public DeltaOne(String z, String A) {
        this.z = z;
        this.A = A;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.z);
        hash = 53 * hash + Objects.hashCode(this.A);
        return hash;
    }    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeltaOne other = (DeltaOne) obj;
        if (!Objects.equals(this.z, other.z)) {
            return false;
        }
        if (!Objects.equals(this.A, other.A)) {
            return false;
        }
        return true;
    }
}
