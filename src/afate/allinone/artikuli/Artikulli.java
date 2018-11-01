package afate.allinone.artikuli;

import java.util.Objects;

public class Artikulli {
    private double cmimi;

    public Artikulli(double cmimi) throws EventException {
        if (cmimi <= 0) {
            throw new EventException("Cmimi nuk duhet te jete negativ.");
        }
        this.cmimi = cmimi;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(double cmimi) {
        this.cmimi = cmimi;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Artikulli) {
            Artikulli a = (Artikulli) o;
            return hashCode() == a.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cmimi);
    }
}
