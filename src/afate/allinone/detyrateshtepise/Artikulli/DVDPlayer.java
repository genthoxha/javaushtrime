package afate.allinone.detyrateshtepise.Artikulli;

public class DVDPlayer extends Artikulli implements Klasifikohet{
    private boolean hasSurround;

    public DVDPlayer(int barkodi, String emertimi, double cmimi, boolean hasSurround) throws BlerjaException {
        super(barkodi, emertimi, cmimi);
        this.hasSurround = hasSurround;
    }

    public boolean hasSurround() {
        return hasSurround;
    }

    public void hasSurround(boolean hasSurround) {
        this.hasSurround = hasSurround;
    }

    @Override
    public boolean montohet(){
        return false;
    }

    @Override
    public String getKlasifikimi(){
        return "Pajisje Elektrike";
    }

    @Override
    public String toString(){
        return "DVD Player "+super.toString()+(hasSurround ? " me " : " pa ")+"Surround";
    }




}



