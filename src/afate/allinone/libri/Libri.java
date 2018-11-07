package afate.allinone.libri;

public class Libri {

    private int isbn; //readonly
    private String titulli;
    private int vitiPublikimit;

    public Libri(int i, String t, int vP) throws LibriException{
        if(i <= 0)
            throw new LibriException("ISBN duhet te jete pozitiv!");
        if(t == null || t.trim().equals(""))
            throw new LibriException("Titulli nuk mund te jete i zbrazet!");
        if(vP <= 0)
            throw new LibriException("Viti i publikimit duhet te jete pozitiv!");
        isbn = i;
        titulli = t;
        vitiPublikimit = vP;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitulli() {
        return titulli;
    }

    public int getVitiPublikimit() {
        return vitiPublikimit;
    }

    public void setTitulli(String t) throws LibriException {
        if(t == null || t.trim().isEmpty())
            throw new LibriException("Titulli nuk mund te jete i zbrazet!");
        titulli = t;
    }

    public void setVitiPublikimit(int vP) throws LibriException {
        if(vP <= 0)
            throw new LibriException("Viti i publikimit duhet te jete pozitiv!");
        vitiPublikimit = vP;
    }

    public String toString() {
        return isbn + " : " + titulli + " - " + vitiPublikimit;
    }

    public boolean equals(Object o) {
        if (o instanceof Libri) {
            return isbn == ((Libri) o).getIsbn();
        }
        return false;
    }
}

