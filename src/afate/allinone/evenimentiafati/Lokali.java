package afate.allinone.evenimentiafati;

import afate.allinone.lokali.EventException;
import afate.allinone.lokali.Util;

public class Lokali {
    private String emri;
    private int kapaciteti;

    public Lokali(String emri, int kapaciteti) throws afate.allinone.lokali.EventException {
        if (Util.isEmpty(emri)) {
            throw new afate.allinone.lokali.EventException("Lokali: Emri nuk duhet te jete i zbrazet");
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
        if (obj instanceof afate.allinone.lokali.Lokali) {
            afate.allinone.lokali.Lokali l = (afate.allinone.lokali.Lokali) obj;
            return emri.equals(l.getEmri()) && kapaciteti == l.getKapaciteti();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return emri.hashCode() + Integer.hashCode(kapaciteti);
    }
}
