package afate.allinone.pajisja;

public abstract class Pajisja {

    private String nrSerik;
    private String modeli;

    public Pajisja(String nrSerik, String modeli)throws PajisjaException {
        if (nrSerik == null || nrSerik.trim().equals("")) {
            throw new PajisjaException("Pajisja: nr serik nuk duhet te jete vetem zero!");
        }
        if (modeli == null || modeli.trim().equals("")) {
            throw new PajisjaException("Pajisja: Modeli nuk duhet te jete null");
        }
        this.nrSerik = nrSerik;
        this.modeli = modeli;
    }

    public String getNrSerik() {
        return nrSerik;
    }

    public String getModeli() {
        return modeli;
    }

    public String toString() {
        return "Pajisja me NR.Serik: " + nrSerik + " modeli: " + modeli;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pajisja) {
            Pajisja p = (Pajisja) obj;
            return nrSerik == p.getNrSerik();
        }
        return false;
    }

    public int hashCode() {
        return nrSerik.hashCode() + modeli.hashCode();
    }

    public abstract void filloKomunikimin();
}
