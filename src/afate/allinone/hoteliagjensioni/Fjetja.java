package afate.allinone.hoteliagjensioni;

public class Fjetja extends Servisi {
    private double ditet;
    private double cmimi;

    public Fjetja(double cmimi,int ditet) throws SkiException {
        super(cmimi*ditet);
        if (ditet < 0) {
            throw new SkiException("Fjetja: Ditet nuk mund te jene negativ!");
        }
        this.ditet = ditet;
        this.cmimi = cmimi;
    }

//    @Override
//    public double kalkuloCmimin() {
//        return ditet * cmimi;
//    }

    public double getDitet() {
        return ditet;
    }

    public double getCmimi() {
        return cmimi;
    }

    @Override
    public String toString() {
        return super.toString() + ", cmimi llogaritur ditet * cmimi = " + super.cmimi;
    }
}
