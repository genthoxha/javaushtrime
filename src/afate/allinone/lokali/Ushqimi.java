package afate.allinone.lokali;

public class Ushqimi extends Artikulli {

    private String emri;

    public Ushqimi(double cmimi, String emri) throws EventException {
        super(cmimi);
        if (Util.isEmpty(emri)) {
            throw new EventException("Ushqimi: Emri nuk duhet te jete i zbrazet!");
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
    public boolean equals(Object obj) {
        if (obj instanceof Ushqimi) {
            Ushqimi u = (Ushqimi) obj;
            return emri.equals(u.getEmri());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return emri.hashCode();
    }

    @Override
    public String toString() {
        return "Emri: " + emri + " : " + super.toString();
    }


}
