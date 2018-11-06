package afate.allinone.hoteliagjensioni;

public abstract class Servisi {
    protected int cmimi;

    public Servisi(int cmimi) throws SkiException {
        if (cmimi < 0) {
            throw new SkiException("Servisi Konstruktori: Cmimi duhet te jete vlere pozitive");
        }
        this.cmimi = cmimi;
    }

    public int getCmimi() {
        return cmimi;
    }

    public void setCmimi(int cmimi) throws SkiException{
        if (cmimi < 0) {
            throw new SkiException("Servisi setCmimi: Cmimi duhet te jete vlere pozitive");
        }
        this.cmimi = cmimi;
    }

    public abstract void fjetja();

    public abstract void Ushqimi(llojiUshqimit.Vakti vakti);

    public abstract void Skipass();

}
