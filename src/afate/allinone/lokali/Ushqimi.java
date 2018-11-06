package afate.allinone.lokali;

public class Ushqimi extends Artikulli {

    private String emri;

    public Ushqimi(int cmimi, String emri) throws EventException {
        super(cmimi);
        if (Util.isEmpty(emri)) {
            throw new EventException("Ushqimi: Emri nuk duhet te jete i zbrazet");
        }
        this.emri = emri;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @Override
    public String toString() {
        return "Artikulli: " + emri + super.toString();
    }
}
