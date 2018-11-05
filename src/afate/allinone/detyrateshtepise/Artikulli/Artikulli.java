package afate.allinone.detyrateshtepise.Artikulli;


import java.util.Objects;

public abstract class Artikulli {

    private String barkodi;
    private String emertimi;
    private int cmimi;

    public Artikulli(String barkodi, String emertimi, int cmimi) throws ArtikulliException {
        if (barkodi == null || barkodi.trim().isEmpty()) {
            throw new ArtikulliException("Artikulli: Barkodi nuk duhet te jete null");
        }
        if (emertimi == null || emertimi.trim().isEmpty()) {
            throw new ArtikulliException("Artikulli: Emertimi nuk duhet te jete null");
        }
        this.barkodi = barkodi;
        this.emertimi = emertimi;
        this.cmimi = cmimi;
    }

    public String getBarkodi() {
        return barkodi;
    }

    public String getEmertimi() {
        return emertimi;
    }

    public int getCmimi() {
        return cmimi;
    }

    public void setCmimi(int cmimi) {
        this.cmimi = cmimi;
    }

    public String toString() {
        return barkodi + " - " + emertimi + " : " + cmimi;
    }

    public abstract boolean montohet();

    @Override
    public boolean equals(Object o) {
        if (o instanceof Artikulli) {
            Artikulli a = (Artikulli) o;
            return hashCode() == a.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cmimi);
    }
}
