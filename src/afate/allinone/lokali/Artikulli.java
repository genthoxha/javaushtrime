package afate.allinone.lokali;

public abstract class Artikulli {

    private double cmimi;

    public Artikulli(double cmimi) throws EventException {
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
