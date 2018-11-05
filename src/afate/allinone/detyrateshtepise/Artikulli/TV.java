package afate.allinone.detyrateshtepise.Artikulli;

public class TV extends Artikulli implements Klasifikohet {

    private boolean hasSurround;

    public TV(String barkodi, String emertimi, int cmimi, boolean hasSurround) throws ArtikulliException {
        super(barkodi, emertimi, cmimi);
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

    public boolean isHasSurround() {
        return hasSurround;
    }

    public void setHasSurround(boolean hasSurround) {
        this.hasSurround = hasSurround;
    }

    public String toString() {
        return "DVD Player " + super.toString() + (isHasSurround() ? ("Me Surround") : "Pa Surround");
    }
}
