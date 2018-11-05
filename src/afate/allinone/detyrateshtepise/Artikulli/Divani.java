package afate.allinone.detyrateshtepise.Artikulli;

public class Divani extends Artikulli implements Klasifikohet {


    private String ngjyra;

    public Divani(String barkodi, String emertimi, int cmimi, String ngjyra) throws ArtikulliException {
        super(barkodi, emertimi, cmimi);
        this.ngjyra = ngjyra;
    }

    @Override
    public String toString() {
        return "Divani " + super.toString() + " me ngjyra " + ngjyra;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public void setNgjyra(String ngjyra) {
        this.ngjyra = ngjyra;
    }

    @Override
    public boolean montohet() {
        return true;
    }

    @Override
    public String getKlasifikimi() {
        return "Orendi";
    }
}
