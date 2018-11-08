package afate.allinone.hoteliagjensioni;

public class Hoteli {
    private String emri;
    private int kategoria;
    private boolean depo;

    public Hoteli(String emri,int kategoria,boolean depo)throws SkiException{
        if (emri == null || emri.trim().isEmpty()) {
            throw new SkiException("Hoteli: Emri nuk duhet te jete null!");
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

    public int getKategoria() {
        return kategoria;
    }

    public boolean isDepo() {
        return depo;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : " + emri + " : " + kategoria + " : " + (depo ? " perfshihet depo " : " nuk perfshihet depo");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hoteli) {
            Hoteli h = (Hoteli) obj;
            return emri.equals(h.getEmri());
        }
        return false;
    }
}
