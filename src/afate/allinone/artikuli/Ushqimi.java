package afate.allinone.artikuli;

public class Ushqimi extends Artikulli {

    private String emri;

    public Ushqimi(double cmimi, String emri) throws EventException {
        super(cmimi);
        if (Util.isEmpty(emri)) {
            throw new EventException("Emri nuk duhet te jete null!");
        }
        this.emri = emri;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) throws EventException {
        if (Util.isEmpty(emri)) {
            throw new EventException("Emri nuk duhet te jete null!");
        }
        this.emri = emri;
    }
}
