package afate.allinone.hoteliagjensioni;

public abstract class Servisi {

    private double cmimi;

    public Servisi(double cmimi) throws SkiException {
        if (cmimi <= 0) {
            throw new SkiException("Servisi: Cmimi nuk duhet te kete vlere negative!");
        }
        this.cmimi = cmimi;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(double cmimi) throws SkiException {
        if (cmimi <= 0) {
            throw new SkiException("Servisi: Cmimi nuk duhet te kete vlere negative!");
        }
        this.cmimi = cmimi;
    }

    @Override
    public String toString() {
        return "Servisi me cmimin: " + cmimi;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Servisi) {
            Servisi s = (Servisi) obj;
        }
        return false;
    }
}
