package afate.allinone.detyrateshtepise.Artikulli;

public class Divani extends Artikulli implements Klasifikohet {
    private String ngjyra;

    public Divani(int barkodi, String emertimi, double cmimi, String ngjyra) throws BlerjaException {
        super(barkodi, emertimi, cmimi);
        if(ngjyra == null || ngjyra.trim().isEmpty()){
            throw new BlerjaException("Materiali nuk duhet te jete i zbrazet");
        }
        this.ngjyra = ngjyra;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public void setNgjyra(String ngjyra) throws BlerjaException{
        if(ngjyra == null || ngjyra.trim().isEmpty()){
            throw new BlerjaException("Materiali nuk duhet te jete i zbrazet");
        }
        this.ngjyra = ngjyra;
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
        return "Divani "+super.toString()+" me ngjyre "+ngjyra;
    }




}
