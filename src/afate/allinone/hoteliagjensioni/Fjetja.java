package afate.allinone.hoteliagjensioni;

public class Fjetja {

    private int ditetEQendrimit;
    private double cmimi;

    public Fjetja(double cmimi, int ditetEQendrimit) throws SkiException {
        if (ditetEQendrimit < 0) {
            throw new SkiException("Fjetja: Ditet e qenrimit nuk duhet te kene vlere negative!");
        }
        if (cmimi < 0) {
            throw new SkiException("Fjetja: Cmimi nuk duhet");
        }
        this.ditetEQendrimit = ditetEQendrimit;
        this.cmimi = ditetEQendrimit * cmimi;
    }

    public int getDitetEQendrimit() {
        return ditetEQendrimit;
    }

    public void setDitetEQendrimit(int ditetEQendrimit) {
        this.ditetEQendrimit = ditetEQendrimit;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(double cmimi) throws SkiException {
        if (cmimi < 0) {
            throw new SkiException("Fjetja: Cmimi nuk duhet");
        }
        this.cmimi = cmimi;
    }

    public String toString() {
        return "Fjetja per dite te qendrimit: " + ditetEQendrimit;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(ditetEQendrimit) + Double.hashCode(cmimi);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fjetja) {
            Fjetja f = (Fjetja) obj;
            return f.ditetEQendrimit == ditetEQendrimit && cmimi == f.getCmimi();
        }
        return false;
    }
}
