package afate.allinone.detyrateshtepise.Artikulli;

public class Tavolina extends Artikulli implements Klasifikohet{
    private String materiali;

    public Tavolina(int barkodi, String emertimi, double cmimi, String materiali) throws BlerjaException {
        super(barkodi, emertimi, cmimi);
        if(materiali == null || materiali.trim().isEmpty()){
            throw new BlerjaException("Materiali nuk duhet te jete i zbrazet");
        }
        this.materiali = materiali;
    }

    public String getMateriali() {
        return materiali;
    }

    public void setMateriali(String materiali) throws BlerjaException{
        if(materiali == null || materiali.trim().isEmpty()){
            throw new BlerjaException("Materiali nuk duhet te jete i zbrazet");
        }
        this.materiali = materiali;
    }

    @Override
    public boolean montohet(){
        return true;
    }

    @Override
    public String getKlasifikimi(){
        return "Orendi";
    }

    @Override
    public String toString(){
        return "Tavolina "+super.toString()+" prej "+materiali;
    }

}
