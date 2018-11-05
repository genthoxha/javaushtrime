package afate.allinone.detyrateshtepise.Artikulli;

public class Tavolina extends Artikulli implements Klasifikohet {

    private String materiali;

    public Tavolina(String barkodi, String emertimi, int cmimi, String materiali) throws ArtikulliException {
        super(barkodi, emertimi, cmimi);
        this.materiali = materiali;
    }

    public boolean montohet() {
        return true;
    }

    @Override
    public String getKlasifikimi() {
        return "Orendi";
    }

    @Override
    public String toString() {
        return "Tavolina " + super.toString() + " prej " + materiali;
    }
}
