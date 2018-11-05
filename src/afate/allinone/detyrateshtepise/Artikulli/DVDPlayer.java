package afate.allinone.detyrateshtepise.Artikulli;

public class DVDPlayer extends Artikulli implements Klasifikohet {


    private boolean hasSurround;

    public DVDPlayer(String barkodi, String emertimi, int cmimi, boolean hasSurround) throws ArtikulliException {

        super(barkodi, emertimi, cmimi);
        this.hasSurround = hasSurround;
    }

    public boolean isHasSurround() {
        return hasSurround;
    }

    public void setHasSurround(boolean hasSurround) {
        this.hasSurround = hasSurround;
    }

    @Override
    public boolean montohet() {
        return false;
    }

    @Override
    public String getKlasifikimi() {
        return "Pajisje Elektrike";
    }
}



