package afate.allinone.hoteliagjensioni;

public class Hoteli {
    private String emri;
    private int kategoria;
    private boolean depo;

    public Hoteli(String emri, int kategoria, boolean depo) throws SkiException {
        if (Util.isEmpty(emri)) {
            throw new SkiException("Hoteli: Emri nuk duhet te jete i zbrazet!");
        }
        if (kategoria < 1 || kategoria > 5) {
            throw new SkiException("Hoteli: Kategoria duhet te jete ndermjet 1 dhe 5");
        }
        this.emri = emri;
        this.kategoria = kategoria;
        this.depo = depo;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public int getKategoria() {
        return kategoria;
    }

    public void setKategoria(int kategoria) {
        this.kategoria = kategoria;
    }

    public boolean isDepo() {
        return depo;
    }

    public void setDepo(boolean depo) {
        this.depo = depo;
    }

    public String toString() {
        return "Hoteli: " + emri + " : " + " Kategoria: " + kategoria + " : " + depo;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Hoteli) {
            Hoteli hoteli = (Hoteli) obj;
            return emri.equals(hoteli.getEmri()) && kategoria == hoteli.getKategoria();
        }
        return false;
    }

    public int hashCode() {
        return emri.hashCode() + Integer.hashCode(kategoria) + Boolean.hashCode(depo);
    }
}
