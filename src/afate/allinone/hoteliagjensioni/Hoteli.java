package afate.allinone.hoteliagjensioni;

public class Hoteli {

    private String emri;
    private int kategoria;
    private boolean depo;

    public Hoteli(String emri, int kategoria, boolean depo) throws SkiException {
        if (emri == null || emri.trim().equals("")) {
            throw new SkiException("Hoteli: Emri i hotelit nuk duhet te jete null ose i zbrazet!");
        }
        if (kategoria < 1 || kategoria > 5) {
            throw new SkiException("Hoteli: Kategoria e hotelit duhet te jete 1 ose 5!");
        }
        this.emri = emri;
        this.kategoria = kategoria;
        this.depo = depo;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) throws SkiException {
        if (emri == null || emri.trim().equals("")) {
            throw new SkiException("Hoteli: Emri i hotelit nuk duhet te jete null ose i zbrazet!");
        }
        this.emri = emri;
    }

    public int getKategoria() {
        return kategoria;
    }

    public void setKategoria(int kategoria) throws SkiException {
        if (kategoria < 1 || kategoria > 5) {
            throw new SkiException("Hoteli: Kategoria e hotelit duhet te jete 1 ose 5!");
        }
        this.kategoria = kategoria;
    }

    public boolean isDepo() {
        return depo;
    }

    public void setDepo(boolean depo) {
        this.depo = depo;
    }

    public String toString() {
        return "Hoteli: " + emri + " : kategoria: " + kategoria + " : " + (depo ? "ka depo " : "nuk ka depo");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hoteli) {
            Hoteli hoteli = (Hoteli) obj;
            return emri.equals(hoteli.getEmri()) && kategoria == hoteli.getKategoria() && depo == hoteli.isDepo();
        }
        return false;
    }

    public int hashCode() {
        return emri.hashCode() + Integer.hashCode(kategoria) + Boolean.hashCode(depo);
    }
}
