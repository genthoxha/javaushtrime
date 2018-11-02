package afate.allinone.pajisja;


import java.util.Vector;

public class Kompjuteri extends Pajisja implements Komunikimi {

    private Vector<Email> listaK;

    public Kompjuteri(String nrSerik, String modeli) throws PajisjaException {

        super(nrSerik, modeli);
        listaK = new Vector<>();
    }

    @Override
    public void filloKomunikimin() {
        System.out.println("Filloi komunikimin nga kompjuteri me nrSerik: " + getNrSerik());
    }

    @Override
    public void dergoMesazhin(String mesazhi, String adresa, boolean kaBashkangjitje)throws PajisjaException {
        listaK.add(new Email(mesazhi, adresa, kaBashkangjitje));
    }
}
