package afate.allinone.hoteliagjensioni;

public abstract class Servisi {

    protected double cmimi;

    public Servisi(double cmimi) throws SkiException {
        if (cmimi < 0) {
            throw new SkiException("Servisi: Cmimi nuk duhet te jete negativ!");
        }
        this.cmimi = cmimi;
    }

//    public abstract double kalkuloCmimin();


    public double getCmimi() {
        return cmimi;
    }

    @Override
    public String toString() {
        return "Sherbimi i natyres: " + this.getClass().getSimpleName() + " me cmimin: " + this.cmimi;
    }
}
