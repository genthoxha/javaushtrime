package afate.allinone.detyrateshtepise.Artikulli;

public class TV extends Artikulli implements Klasifikohet{
    private boolean isSmart;

    public TV(int barkodi, String emertimi, double cmimi, boolean isSmart) throws BlerjaException {
        super(barkodi, emertimi, cmimi);
        this.isSmart = isSmart;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void isSmart(boolean isSmart) {
        this.isSmart = isSmart;
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
        return (isSmart ? "Smart " : "Not Smart ")+"TV "+super.toString();
    }


}
