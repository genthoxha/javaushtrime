package afate.allinone.evenimentiafati;

import afate.allinone.lokali.EventException;

public abstract class Artikulli {

    protected double cmimi;

    public Artikulli(double cmimi) throws afate.allinone.lokali.EventException {
        if (cmimi <= 0) {
            throw new EventException("Artikulli: Cmimi duhet te kete vlere pozitive dhe jo Zero");
        }
        this.cmimi = cmimi;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(double cmimi) {
        this.cmimi = cmimi;
    }

    public String toString() {
        return "Artikulli me cmimin: " + cmimi;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Artikulli) {
            Artikulli a = (Artikulli) obj;
        }
        return false;
    }

}
