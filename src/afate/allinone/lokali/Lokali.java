package afate.allinone.lokali;

public class Lokali {
    private String emri;
    private int kapaciteti;

    public Lokali(String emri, int kapaciteti) throws EventException {
        if (Util.isEmpty(emri)) {
            throw new EventException("Lokali: Emri nuk duhet te jete i zbrazet");
        }
        if (kapaciteti < 20) {
            throw new EventException("Lokali: Kapaciteti nuk duhet te jete me i vogel se 20");
        }
        this.emri = emri;
        this.kapaciteti = kapaciteti;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public int getKapaciteti() {
        return kapaciteti;
    }

    public void setKapaciteti(int kapaciteti) {
        this.kapaciteti = kapaciteti;
    }

    @Override
    public String toString() {
        return "Lokali: " + emri + " : " + kapaciteti;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lokali) {
            Lokali l = (Lokali) obj;
            return emri.equals(l.getEmri()) && kapaciteti == l.getKapaciteti();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return emri.hashCode() + Integer.hashCode(kapaciteti);
    }
}
