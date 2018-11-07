package afate.allinone.hoteliagjensioni;

public class Ushqimi implements llojiUshqimit {

    private double cmimi;
    private llojiUshqimit.lloji lloji;

    public Ushqimi(double cmimi, llojiUshqimit.lloji lloji) throws SkiException {
        if (cmimi < 0) {
            throw new SkiException("Ushqimi: Cmimi i ushqimit nuk duhet te jete negativ!");
        }
        if (lloji == null) {
            throw new SkiException("Ushqimi: Lloji ushqimit nuk duhet te jete i zbrazet!");
        }
        this.cmimi = cmimi;
        this.lloji = lloji;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(double cmimi) {
        this.cmimi = cmimi;
    }

    public llojiUshqimit.lloji getLloji() {
        return lloji;
    }

    public void setLloji(llojiUshqimit.lloji lloji) {
        this.lloji = lloji;
    }
}
