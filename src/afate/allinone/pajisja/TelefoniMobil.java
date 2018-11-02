package afate.allinone.pajisja;

import java.util.Vector;

public class TelefoniMobil extends Pajisja implements Komunikimi {

    private boolean isSmart;
    private Vector<Komunikimi> komunikimet;

    public TelefoniMobil(String nrSerik, String modeli, boolean isSmart) throws PajisjaException {
        super(nrSerik, modeli);
        this.isSmart = isSmart;
        this.komunikimet = new Vector<>();
    }

    @Override
    public void dergoMesazhin(String mesazhi, String adresa, boolean kaBashkangjitje) throws PajisjaException {
        if (isSmart)
            komunikimet.add(new Viber(mesazhi, adresa, kaBashkangjitje));
        System.out.println("Komunikimi permes Viber: " + mesazhi + " : " + adresa + (kaBashkangjitje ? "Ka bashkangjitje " : "Ska bashkangjitje"));
    }

    @Override
    public void filloKomunikimin() {
        System.out.println("Filloi komunikimi nga telefoni " + (isSmart ? "I menqur " : "Jo i menqur") + " me nrSerik: " + getNrSerik());
    }
}
